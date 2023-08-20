grammar Grammar;

@header{
	import java.util.*;
	import br.edu.ufabc.compiler.ast.*;
	import br.edu.ufabc.compiler.symbols.*;
	import br.edu.ufabc.compiler.expression.*;
	import br.edu.ufabc.compiler.exception.*;

}

@members{
	private ArrayList<String> listaDeTokens = new ArrayList<String>();
	private SymbolTable symbolTable = new SymbolTable();
    private DataType currentType;
    private DataType leftDT;
    private DataType rightDT;
    private Expression expression;
    private String idAtribuido;
    private String text;
    private Program program = new Program();
    private Stack<List<Command>> stack = new Stack<List<Command>>();

	public void exibirTodosTokens(){
		for(String s: listaDeTokens){
			System.out.println("Token: " + s);
		}
	}

	public void exibirSimbolos(){
	    System.out.println(symbolTable);
	}

	public String generateJavaCode(){
		return program.generateJavaCode();
	}
	public String generateJavaScriptCode(){
		return program.generateJavaScriptCode();
	}

}

prog     : 'programa'
            {
                program.setSymbolTable(symbolTable);
                stack.push(new ArrayList<Command>());
            }
            declara? bloco? 'fimprog.'
            {
                program.setComandos(stack.pop());
            }
         ;

declara  : (declaravar)+
         ;

declaravar : tipo ID
            {
                symbolTable.declareVariable(_input.LT(-1).getText(), currentType);
                List<Identifier> ids = new ArrayList<>();
                ids.add(symbolTable.get(_input.LT(-1).getText()));
            }
            (COMMA
                  ID
                  {
                      symbolTable.declareVariable(_input.LT(-1).getText(), currentType);
                      ids.add(symbolTable.get(_input.LT(-1).getText()));
                  }
            )*SC
            {
                CmdDeclaration _cmdDeclaration = new CmdDeclaration(ids);
                stack.peek().add(_cmdDeclaration);
            }
           ;

tipo     : 'real' { currentType = DataType.REAL; }
         | 'inteiro' { currentType = DataType.INTEIRO; }
         | 'texto' { currentType = DataType.TEXTO; }
         | 'logico' { currentType = DataType.LOGICO; }
         ;

bloco    : (cmd)+
         ;

cmd      : cmdLeitura SC
         | cmdEscrita SC
         | cmdAttr SC
         | cmdIf
         | cmdWhile
         | cmdDoWhile
         | expr SC
         ;

cmdLeitura : 'leia'
            AP
            ID
            {
                symbolTable.checkDeclaration(_input.LT(-1).getText());
                Identifier id = symbolTable.get(_input.LT(-1).getText());
                if (id == null){
                    throw new SemanticException("Undeclared Variable");
                }
                CmdRead _read = new CmdRead(id);
                stack.peek().add(_read);
            }
            FP
           ;

cmdEscrita : 'escreva'
            AP (
                    TEXTO
                    {
                        CmdWrite _write = new CmdWrite(_input.LT(-1).getText());
                        stack.peek().add(_write);

                    }
                    | ID
                    {
                        try{
                            symbolTable.checkUsage(_input.LT(-1).getText());
                            Identifier id = symbolTable.get(_input.LT(-1).getText());
                            if (id == null){
                                throw new SemanticException("Undeclared Variable");
                            }
                            CmdWrite _write = new CmdWrite(id);
                            stack.peek().add(_write);
                        } catch(SemanticException e){
                            notifyErrorListeners(e.getMessage());
                        }
                    }
            ) FP
           ;

cmdAttr  : ID{
                try{
                symbolTable.checkDeclaration(_input.LT(-1).getText());
                idAtribuido = _input.LT(-1).getText();
                if (!symbolTable.exists(_input.LT(-1).getText())){
                    throw new SemanticException("Variável não declarada.");
                }
                leftDT = symbolTable.get(_input.LT(-1).getText()).getType();
                }catch(SemanticException e){
                    notifyErrorListeners(e.getMessage());
                    idAtribuido = null;
                    leftDT = null;
                }
             }
           ':='
           (
           LOGICO { expression = new BooleanExpression(_input.LT(-1).getText().equals("VERDADEIRO")); }
           |
           expr
           |
           exprBool
           |
           TEXTO { expression = new TextExpression(_input.LT(-1).getText()); })
            {
                try{
                symbolTable.assignValue(idAtribuido, expression);

                System.out.println("EVAL ("+expression+") = "+expression.eval());

                CmdAttrib _attr = new CmdAttrib(symbolTable.get(idAtribuido), expression);
                stack.peek().add(_attr);
                }catch(SemanticException e){
                    //notificar somente se existir uma variável
                    if(idAtribuido != null)
                        notifyErrorListeners(e.getMessage());
                }catch(NullPointerException e){
                    //nao faz nada
                }finally{
                expression = null;
                }
            }

         ;

cmdIf    : 'se'
            {
				stack.push(new ArrayList<Command>());
				CmdIf _cmdIf = new CmdIf();
            }
            AP
            exprBool
            FP {_cmdIf.setExpr(expression);}
            '{' bloco {_cmdIf.setListaTrue(stack.pop());}
             '}'
            ('senao' '{' {stack.push(new ArrayList<Command>());}
            bloco
                {_cmdIf.setListaFalse(stack.pop());}
            '}')?
            {
   				stack.peek().add(_cmdIf);
   			}
         ;

cmdWhile : 'enquanto'
            {
				stack.push(new ArrayList<Command>());
				CmdWhile _cmdWhile = new CmdWhile();
            }
            AP
            exprBool
            FP {_cmdWhile.setExpr(expression);}
            '{' bloco {_cmdWhile.setLista(stack.pop());}
            '}'
            {
                stack.peek().add(_cmdWhile);
            }
         ;

cmdDoWhile : 'faca'
             {
				stack.push(new ArrayList<Command>());
				CmdWhile _cmdWhile = new CmdDoWhile();
             }
             '{' bloco {_cmdWhile.setLista(stack.pop());}
             '}' 'enquanto' AP exprBool FP SC{_cmdWhile.setExpr(expression);}
             {
                stack.peek().add(_cmdWhile);
             }
           ;

exprBool : (exprBooll) (
            OP_BOOL
            {
                String operator = _input.LT(-1).getText().split(" ")[0];
                BinaryExpression _exprBool = new BinaryExpression(operator);
                _exprBool.setLeftSide(expression);
            }
            (exprBooll)
            {
                _exprBool.setRightSide(expression);
                expression = _exprBool;
            }
            )*
         ;

exprBooll : AP exprBool FP
          | LOGICO { expression = new BooleanExpression(_input.LT(-1).getText().equals("VERDADEIRO"));}
          | exprRel
          ;

exprRel  : expr
           OP_REL
            {
                String operator = _input.LT(-1).getText().split(" ")[0];
                BinaryExpression _exprRel = new BinaryExpression(operator);
                _exprRel.setLeftSide(expression);
            }
           expr
            {
                _exprRel.setRightSide(expression);
                expression = _exprRel;
            }
         ;

expr	 : termo
         | termo exprl+
         ;

exprl	 : OP_ADD
        {
            String operator = _input.LT(-1).getText().split(" ")[0];
            BinaryExpression _exprADD = new BinaryExpression(operator);
            _exprADD.setLeftSide(expression);
        }
          termo
        {
            _exprADD.setRightSide(expression);
            expression = _exprADD;
        }
        ;

termo    : fator
         | fator termol+
         ;

termol   : OP_MULT {
              String operator = _input.LT(-1).getText().split(" ")[0];
              BinaryExpression _exprMult = new BinaryExpression(operator);
              _exprMult.setLeftSide(expression);
          }
          fator
          {
              _exprMult.setRightSide(expression);
              expression = _exprMult;
          }
          ;

fator    : ID   {
                    try{
                        listaDeTokens.add(_input.LT(-1).getText());
                        symbolTable.checkUsage(_input.LT(-1).getText());
                        Identifier id = symbolTable.get(_input.LT(-1).getText());
                        expression = new IdentifierExpression(id);
                    } catch(SemanticException e){
                        notifyErrorListeners(e.getMessage());
                    }
                }
         | num
         | AP expr FP
         ;

OP_ADD   : '+' | '-'
         ;

OP_MULT  :  '*'
         | '/'
         | '//'  //divisao inteira
         ;

OP_REL   : '>' | '<' | '>=' | '<=' | '==' | '!='
         ;

OP_BOOL  : '&&' | '||'
         ;

TEXTO    : ["] .*? ["]
         ;

num      : INTEGER { expression = new IntegerNumberExpression(Integer.parseInt(_input.LT(-1).getText())); }
         | REAL { expression = new DoubleNumberExpression(Double.parseDouble(_input.LT(-1).getText())); }
         //TODO Criar expressoes apropriadas para tratar os literais não decimais
         | HEXADECIMAL { expression = new IntegerNumberExpression(Integer.parseInt(_input.LT(-1).getText().substring(2), 16)); }
         | BINARY { expression = new IntegerNumberExpression(Integer.parseInt(_input.LT(-1).getText().substring(2), 2)); }
         | OCTAL { expression = new IntegerNumberExpression(Integer.parseInt(_input.LT(-1).getText().substring(1), 8)); }
         ;

INTEGER  : '0' | [1-9][0-9]*
         ;

REAL     : ('0.' | [1-9])+ ('.' [0-9]+)?
		 ;

LOGICO   : 'VERDADEIRO' | 'FALSO'
		 ;

ID		 : [a-zA-Z] ([a-zA-Z0-9])*
		 ;

HEXADECIMAL : ('0x' | '0X')([0-9A-F])+
            ;
BINARY      : ('0b' | '0B')[0-1]+
            ;
OCTAL       : ('0')[0-7]+
            ;

SC      : ';'
         ;

COMMA    : ','
		 ;

WS       : (' ' | '\t' | '\n' | '\r') -> skip
         ;

AP       : '('
         ;

FP       : ')'
         ;

SINGLE_LINE_COMMENT : '#' ~[\r\n]* -> skip
                    ;

balancedParentheses
    : AP balancedParentheses FP
    | AP FP
    | balancedParentheses balancedParentheses
    ;