// Generated from Grammar.g4 by ANTLR 4.13.0
package br.edu.ufabc.compiler.parser;

	import java.util.*;
	import br.edu.ufabc.compiler.ast.*;
	import br.edu.ufabc.compiler.symbols.*;
	import br.edu.ufabc.compiler.expression.*;
	import br.edu.ufabc.compiler.exception.*;


import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, OP_ADD=16, 
		OP_MULT=17, OP_REL=18, OP_BOOL=19, TEXTO=20, INTEGER=21, REAL=22, LOGICO=23, 
		ID=24, HEXADECIMAL=25, BINARY=26, OCTAL=27, SC=28, COMMA=29, WS=30, AP=31, 
		FP=32, SINGLE_LINE_COMMENT=33;
	public static final int
		RULE_prog = 0, RULE_declara = 1, RULE_declaravar = 2, RULE_tipo = 3, RULE_bloco = 4, 
		RULE_cmd = 5, RULE_cmdLeitura = 6, RULE_cmdEscrita = 7, RULE_cmdAttr = 8, 
		RULE_cmdIf = 9, RULE_cmdWhile = 10, RULE_cmdDoWhile = 11, RULE_exprBool = 12, 
		RULE_exprBooll = 13, RULE_exprRel = 14, RULE_expr = 15, RULE_exprl = 16, 
		RULE_termo = 17, RULE_termol = 18, RULE_fator = 19, RULE_num = 20, RULE_balancedParentheses = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "declara", "declaravar", "tipo", "bloco", "cmd", "cmdLeitura", 
			"cmdEscrita", "cmdAttr", "cmdIf", "cmdWhile", "cmdDoWhile", "exprBool", 
			"exprBooll", "exprRel", "expr", "exprl", "termo", "termol", "fator", 
			"num", "balancedParentheses"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog.'", "'real'", "'inteiro'", "'texto'", "'logico'", 
			"'leia'", "'escreva'", "':='", "'se'", "'{'", "'}'", "'senao'", "'enquanto'", 
			"'faca'", null, null, null, null, null, null, null, null, null, null, 
			null, null, "';'", "','", null, "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "OP_ADD", "OP_MULT", "OP_REL", "OP_BOOL", "TEXTO", 
			"INTEGER", "REAL", "LOGICO", "ID", "HEXADECIMAL", "BINARY", "OCTAL", 
			"SC", "COMMA", "WS", "AP", "FP", "SINGLE_LINE_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


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


	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public DeclaraContext declara() {
			return getRuleContext(DeclaraContext.class,0);
		}
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(T__0);

			                program.setSymbolTable(symbolTable);
			                stack.push(new ArrayList<Command>());
			            
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 120L) != 0)) {
				{
				setState(46);
				declara();
				}
			}

			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2405483904L) != 0)) {
				{
				setState(49);
				bloco();
				}
			}

			setState(52);
			match(T__1);

			                program.setComandos(stack.pop());
			                symbolTable.checkForUnusedVariables();
			            
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaraContext extends ParserRuleContext {
		public List<DeclaravarContext> declaravar() {
			return getRuleContexts(DeclaravarContext.class);
		}
		public DeclaravarContext declaravar(int i) {
			return getRuleContext(DeclaravarContext.class,i);
		}
		public DeclaraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declara; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterDeclara(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitDeclara(this);
		}
	}

	public final DeclaraContext declara() throws RecognitionException {
		DeclaraContext _localctx = new DeclaraContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declara);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(55);
				declaravar();
				}
				}
				setState(58); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 120L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaravarContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(GrammarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(GrammarParser.ID, i);
		}
		public TerminalNode SC() { return getToken(GrammarParser.SC, 0); }
		public List<TerminalNode> COMMA() { return getTokens(GrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GrammarParser.COMMA, i);
		}
		public DeclaravarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaravar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterDeclaravar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitDeclaravar(this);
		}
	}

	public final DeclaravarContext declaravar() throws RecognitionException {
		DeclaravarContext _localctx = new DeclaravarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaravar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			tipo();
			setState(61);
			match(ID);

			                symbolTable.declareVariable(_input.LT(-1).getText(), currentType);
			                List<Identifier> ids = new ArrayList<>();
			                ids.add(symbolTable.get(_input.LT(-1).getText()));
			            
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(63);
				match(COMMA);
				setState(64);
				match(ID);

				                      symbolTable.declareVariable(_input.LT(-1).getText(), currentType);
				                      ids.add(symbolTable.get(_input.LT(-1).getText()));
				                  
				}
				}
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(71);
			match(SC);

			                CmdDeclaration _cmdDeclaration = new CmdDeclaration(ids);
			                stack.peek().add(_cmdDeclaration);
			            
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitTipo(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tipo);
		try {
			setState(82);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				match(T__2);
				 currentType = DataType.REAL; 
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				match(T__3);
				 currentType = DataType.INTEIRO; 
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(78);
				match(T__4);
				 currentType = DataType.TEXTO; 
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 4);
				{
				setState(80);
				match(T__5);
				 currentType = DataType.LOGICO; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlocoContext extends ParserRuleContext {
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitBloco(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(84);
				cmd();
				}
				}
				setState(87); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2405483904L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdContext extends ParserRuleContext {
		public CmdLeituraContext cmdLeitura() {
			return getRuleContext(CmdLeituraContext.class,0);
		}
		public TerminalNode SC() { return getToken(GrammarParser.SC, 0); }
		public CmdEscritaContext cmdEscrita() {
			return getRuleContext(CmdEscritaContext.class,0);
		}
		public CmdAttrContext cmdAttr() {
			return getRuleContext(CmdAttrContext.class,0);
		}
		public CmdIfContext cmdIf() {
			return getRuleContext(CmdIfContext.class,0);
		}
		public CmdWhileContext cmdWhile() {
			return getRuleContext(CmdWhileContext.class,0);
		}
		public CmdDoWhileContext cmdDoWhile() {
			return getRuleContext(CmdDoWhileContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitCmd(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmd);
		try {
			setState(104);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				cmdLeitura();
				setState(90);
				match(SC);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(92);
				cmdEscrita();
				setState(93);
				match(SC);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(95);
				cmdAttr();
				setState(96);
				match(SC);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(98);
				cmdIf();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(99);
				cmdWhile();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(100);
				cmdDoWhile();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(101);
				expr();
				setState(102);
				match(SC);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdLeituraContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(GrammarParser.AP, 0); }
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public TerminalNode FP() { return getToken(GrammarParser.FP, 0); }
		public CmdLeituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdLeitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterCmdLeitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitCmdLeitura(this);
		}
	}

	public final CmdLeituraContext cmdLeitura() throws RecognitionException {
		CmdLeituraContext _localctx = new CmdLeituraContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdLeitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(T__6);
			setState(107);
			match(AP);
			setState(108);
			match(ID);

			                symbolTable.checkDeclaration(_input.LT(-1).getText());
			                Identifier id = symbolTable.get(_input.LT(-1).getText());
			                if (id == null){
			                    throw new SemanticException("Undeclared Variable");
			                }
			                CmdRead _read = new CmdRead(id);
			                stack.peek().add(_read);
			            
			setState(110);
			match(FP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdEscritaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(GrammarParser.AP, 0); }
		public TerminalNode FP() { return getToken(GrammarParser.FP, 0); }
		public TerminalNode TEXTO() { return getToken(GrammarParser.TEXTO, 0); }
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public CmdEscritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdEscrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterCmdEscrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitCmdEscrita(this);
		}
	}

	public final CmdEscritaContext cmdEscrita() throws RecognitionException {
		CmdEscritaContext _localctx = new CmdEscritaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdEscrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(T__7);
			setState(113);
			match(AP);
			setState(118);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TEXTO:
				{
				setState(114);
				match(TEXTO);

				                        CmdWrite _write = new CmdWrite(_input.LT(-1).getText());
				                        stack.peek().add(_write);

				                    
				}
				break;
			case ID:
				{
				setState(116);
				match(ID);

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
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(120);
			match(FP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdAttrContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public TerminalNode LOGICO() { return getToken(GrammarParser.LOGICO, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprBoolContext exprBool() {
			return getRuleContext(ExprBoolContext.class,0);
		}
		public TerminalNode TEXTO() { return getToken(GrammarParser.TEXTO, 0); }
		public CmdAttrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdAttr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterCmdAttr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitCmdAttr(this);
		}
	}

	public final CmdAttrContext cmdAttr() throws RecognitionException {
		CmdAttrContext _localctx = new CmdAttrContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdAttr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(ID);

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
			             
			setState(124);
			match(T__8);
			setState(131);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(125);
				match(LOGICO);
				 expression = new BooleanExpression(_input.LT(-1).getText().equals("VERDADEIRO")); 
				}
				break;
			case 2:
				{
				setState(127);
				expr();
				}
				break;
			case 3:
				{
				setState(128);
				exprBool();
				}
				break;
			case 4:
				{
				setState(129);
				match(TEXTO);
				 expression = new TextExpression(_input.LT(-1).getText()); 
				}
				break;
			}

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
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdIfContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(GrammarParser.AP, 0); }
		public ExprBoolContext exprBool() {
			return getRuleContext(ExprBoolContext.class,0);
		}
		public TerminalNode FP() { return getToken(GrammarParser.FP, 0); }
		public List<BlocoContext> bloco() {
			return getRuleContexts(BlocoContext.class);
		}
		public BlocoContext bloco(int i) {
			return getRuleContext(BlocoContext.class,i);
		}
		public CmdIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterCmdIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitCmdIf(this);
		}
	}

	public final CmdIfContext cmdIf() throws RecognitionException {
		CmdIfContext _localctx = new CmdIfContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdIf);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(T__9);

							stack.push(new ArrayList<Command>());
							CmdIf _cmdIf = new CmdIf();
			            
			setState(137);
			match(AP);
			setState(138);
			exprBool();
			setState(139);
			match(FP);
			_cmdIf.setExpr(expression);
			setState(141);
			match(T__10);
			setState(142);
			bloco();
			_cmdIf.setListaTrue(stack.pop());
			setState(144);
			match(T__11);
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(145);
				match(T__12);
				setState(146);
				match(T__10);
				stack.push(new ArrayList<Command>());
				setState(148);
				bloco();
				_cmdIf.setListaFalse(stack.pop());
				setState(150);
				match(T__11);
				}
			}


			   				stack.peek().add(_cmdIf);
			   			
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdWhileContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(GrammarParser.AP, 0); }
		public ExprBoolContext exprBool() {
			return getRuleContext(ExprBoolContext.class,0);
		}
		public TerminalNode FP() { return getToken(GrammarParser.FP, 0); }
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public CmdWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdWhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterCmdWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitCmdWhile(this);
		}
	}

	public final CmdWhileContext cmdWhile() throws RecognitionException {
		CmdWhileContext _localctx = new CmdWhileContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cmdWhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(T__13);

							stack.push(new ArrayList<Command>());
							CmdWhile _cmdWhile = new CmdWhile();
			            
			setState(158);
			match(AP);
			setState(159);
			exprBool();
			setState(160);
			match(FP);
			_cmdWhile.setExpr(expression);
			setState(162);
			match(T__10);
			setState(163);
			bloco();
			_cmdWhile.setLista(stack.pop());
			setState(165);
			match(T__11);

			                stack.peek().add(_cmdWhile);
			            
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdDoWhileContext extends ParserRuleContext {
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public TerminalNode AP() { return getToken(GrammarParser.AP, 0); }
		public ExprBoolContext exprBool() {
			return getRuleContext(ExprBoolContext.class,0);
		}
		public TerminalNode FP() { return getToken(GrammarParser.FP, 0); }
		public TerminalNode SC() { return getToken(GrammarParser.SC, 0); }
		public CmdDoWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdDoWhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterCmdDoWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitCmdDoWhile(this);
		}
	}

	public final CmdDoWhileContext cmdDoWhile() throws RecognitionException {
		CmdDoWhileContext _localctx = new CmdDoWhileContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cmdDoWhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(T__14);

							stack.push(new ArrayList<Command>());
							CmdWhile _cmdWhile = new CmdDoWhile();
			             
			setState(170);
			match(T__10);
			setState(171);
			bloco();
			_cmdWhile.setLista(stack.pop());
			setState(173);
			match(T__11);
			setState(174);
			match(T__13);
			setState(175);
			match(AP);
			setState(176);
			exprBool();
			setState(177);
			match(FP);
			setState(178);
			match(SC);
			_cmdWhile.setExpr(expression);

			                stack.peek().add(_cmdWhile);
			             
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprBoolContext extends ParserRuleContext {
		public List<ExprBoollContext> exprBooll() {
			return getRuleContexts(ExprBoollContext.class);
		}
		public ExprBoollContext exprBooll(int i) {
			return getRuleContext(ExprBoollContext.class,i);
		}
		public List<TerminalNode> OP_BOOL() { return getTokens(GrammarParser.OP_BOOL); }
		public TerminalNode OP_BOOL(int i) {
			return getToken(GrammarParser.OP_BOOL, i);
		}
		public ExprBoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprBool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterExprBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitExprBool(this);
		}
	}

	public final ExprBoolContext exprBool() throws RecognitionException {
		ExprBoolContext _localctx = new ExprBoolContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_exprBool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(182);
			exprBooll();
			}
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_BOOL) {
				{
				{
				setState(183);
				match(OP_BOOL);

				                String operator = _input.LT(-1).getText().split(" ")[0];
				                BinaryExpression _exprBool = new BinaryExpression(operator);
				                _exprBool.setLeftSide(expression);
				            
				{
				setState(185);
				exprBooll();
				}

				                _exprBool.setRightSide(expression);
				                expression = _exprBool;
				            
				}
				}
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprBoollContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(GrammarParser.AP, 0); }
		public ExprBoolContext exprBool() {
			return getRuleContext(ExprBoolContext.class,0);
		}
		public TerminalNode FP() { return getToken(GrammarParser.FP, 0); }
		public TerminalNode LOGICO() { return getToken(GrammarParser.LOGICO, 0); }
		public ExprRelContext exprRel() {
			return getRuleContext(ExprRelContext.class,0);
		}
		public ExprBoollContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprBooll; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterExprBooll(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitExprBooll(this);
		}
	}

	public final ExprBoollContext exprBooll() throws RecognitionException {
		ExprBoollContext _localctx = new ExprBoollContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_exprBooll);
		try {
			setState(200);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(193);
				match(AP);
				setState(194);
				exprBool();
				setState(195);
				match(FP);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(197);
				match(LOGICO);
				 expression = new BooleanExpression(_input.LT(-1).getText().equals("VERDADEIRO"));
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(199);
				exprRel();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprRelContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OP_REL() { return getToken(GrammarParser.OP_REL, 0); }
		public ExprRelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprRel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterExprRel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitExprRel(this);
		}
	}

	public final ExprRelContext exprRel() throws RecognitionException {
		ExprRelContext _localctx = new ExprRelContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_exprRel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			expr();
			setState(203);
			match(OP_REL);

			                String operator = _input.LT(-1).getText().split(" ")[0];
			                BinaryExpression _exprRel = new BinaryExpression(operator);
			                _exprRel.setLeftSide(expression);
			            
			setState(205);
			expr();

			                _exprRel.setRightSide(expression);
			                expression = _exprRel;
			            
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public List<ExprlContext> exprl() {
			return getRuleContexts(ExprlContext.class);
		}
		public ExprlContext exprl(int i) {
			return getRuleContext(ExprlContext.class,i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_expr);
		int _la;
		try {
			setState(215);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(208);
				termo();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(209);
				termo();
				setState(211); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(210);
					exprl();
					}
					}
					setState(213); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==OP_ADD );
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprlContext extends ParserRuleContext {
		public TerminalNode OP_ADD() { return getToken(GrammarParser.OP_ADD, 0); }
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public ExprlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterExprl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitExprl(this);
		}
	}

	public final ExprlContext exprl() throws RecognitionException {
		ExprlContext _localctx = new ExprlContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_exprl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			match(OP_ADD);

			            String operator = _input.LT(-1).getText().split(" ")[0];
			            BinaryExpression _exprADD = new BinaryExpression(operator);
			            _exprADD.setLeftSide(expression);
			        
			setState(219);
			termo();

			            _exprADD.setRightSide(expression);
			            expression = _exprADD;
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermoContext extends ParserRuleContext {
		public FatorContext fator() {
			return getRuleContext(FatorContext.class,0);
		}
		public List<TermolContext> termol() {
			return getRuleContexts(TermolContext.class);
		}
		public TermolContext termol(int i) {
			return getRuleContext(TermolContext.class,i);
		}
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_termo);
		int _la;
		try {
			setState(229);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(222);
				fator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(223);
				fator();
				setState(225); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(224);
					termol();
					}
					}
					setState(227); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==OP_MULT );
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermolContext extends ParserRuleContext {
		public TerminalNode OP_MULT() { return getToken(GrammarParser.OP_MULT, 0); }
		public FatorContext fator() {
			return getRuleContext(FatorContext.class,0);
		}
		public TermolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterTermol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitTermol(this);
		}
	}

	public final TermolContext termol() throws RecognitionException {
		TermolContext _localctx = new TermolContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_termol);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(OP_MULT);

			              String operator = _input.LT(-1).getText().split(" ")[0];
			              BinaryExpression _exprMult = new BinaryExpression(operator);
			              _exprMult.setLeftSide(expression);
			          
			setState(233);
			fator();

			              _exprMult.setRightSide(expression);
			              expression = _exprMult;
			          
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FatorContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public NumContext num() {
			return getRuleContext(NumContext.class,0);
		}
		public TerminalNode AP() { return getToken(GrammarParser.AP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FP() { return getToken(GrammarParser.FP, 0); }
		public FatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterFator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitFator(this);
		}
	}

	public final FatorContext fator() throws RecognitionException {
		FatorContext _localctx = new FatorContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_fator);
		try {
			setState(243);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(236);
				match(ID);

				                    try{
				                        listaDeTokens.add(_input.LT(-1).getText());
				                        symbolTable.checkUsage(_input.LT(-1).getText());
				                        Identifier id = symbolTable.get(_input.LT(-1).getText());
				                        expression = new IdentifierExpression(id);
				                    } catch(SemanticException e){
				                        notifyErrorListeners(e.getMessage());
				                    }
				                
				}
				break;
			case INTEGER:
			case REAL:
			case HEXADECIMAL:
			case BINARY:
			case OCTAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(238);
				num();
				}
				break;
			case AP:
				enterOuterAlt(_localctx, 3);
				{
				setState(239);
				match(AP);
				setState(240);
				expr();
				setState(241);
				match(FP);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NumContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(GrammarParser.INTEGER, 0); }
		public TerminalNode REAL() { return getToken(GrammarParser.REAL, 0); }
		public TerminalNode HEXADECIMAL() { return getToken(GrammarParser.HEXADECIMAL, 0); }
		public TerminalNode BINARY() { return getToken(GrammarParser.BINARY, 0); }
		public TerminalNode OCTAL() { return getToken(GrammarParser.OCTAL, 0); }
		public NumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_num; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterNum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitNum(this);
		}
	}

	public final NumContext num() throws RecognitionException {
		NumContext _localctx = new NumContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_num);
		try {
			setState(255);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(245);
				match(INTEGER);
				 expression = new IntegerNumberExpression(Integer.parseInt(_input.LT(-1).getText())); 
				}
				break;
			case REAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(247);
				match(REAL);
				 expression = new DoubleNumberExpression(Double.parseDouble(_input.LT(-1).getText())); 
				}
				break;
			case HEXADECIMAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(249);
				match(HEXADECIMAL);
				 expression = new IntegerNumberExpression(Integer.parseInt(_input.LT(-1).getText().substring(2), 16)); 
				}
				break;
			case BINARY:
				enterOuterAlt(_localctx, 4);
				{
				setState(251);
				match(BINARY);
				 expression = new IntegerNumberExpression(Integer.parseInt(_input.LT(-1).getText().substring(2), 2)); 
				}
				break;
			case OCTAL:
				enterOuterAlt(_localctx, 5);
				{
				setState(253);
				match(OCTAL);
				 expression = new IntegerNumberExpression(Integer.parseInt(_input.LT(-1).getText().substring(1), 8)); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BalancedParenthesesContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(GrammarParser.AP, 0); }
		public List<BalancedParenthesesContext> balancedParentheses() {
			return getRuleContexts(BalancedParenthesesContext.class);
		}
		public BalancedParenthesesContext balancedParentheses(int i) {
			return getRuleContext(BalancedParenthesesContext.class,i);
		}
		public TerminalNode FP() { return getToken(GrammarParser.FP, 0); }
		public BalancedParenthesesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_balancedParentheses; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterBalancedParentheses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitBalancedParentheses(this);
		}
	}

	public final BalancedParenthesesContext balancedParentheses() throws RecognitionException {
		return balancedParentheses(0);
	}

	private BalancedParenthesesContext balancedParentheses(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BalancedParenthesesContext _localctx = new BalancedParenthesesContext(_ctx, _parentState);
		BalancedParenthesesContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_balancedParentheses, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(258);
				match(AP);
				setState(259);
				balancedParentheses(0);
				setState(260);
				match(FP);
				}
				break;
			case 2:
				{
				setState(262);
				match(AP);
				setState(263);
				match(FP);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(270);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BalancedParenthesesContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_balancedParentheses);
					setState(266);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(267);
					balancedParentheses(2);
					}
					} 
				}
				setState(272);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 21:
			return balancedParentheses_sempred((BalancedParenthesesContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean balancedParentheses_sempred(BalancedParenthesesContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001!\u0112\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u00000\b\u0000\u0001\u0000"+
		"\u0003\u00003\b\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0004\u00019\b\u0001\u000b\u0001\f\u0001:\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002C\b\u0002\n\u0002"+
		"\f\u0002F\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u0003S\b\u0003\u0001\u0004\u0004\u0004V\b\u0004\u000b\u0004"+
		"\f\u0004W\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005i\b\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0003\u0007w\b\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u0084\b\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0003\t\u0099\b\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u00bd"+
		"\b\f\n\f\f\f\u00c0\t\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r"+
		"\u0001\r\u0003\r\u00c9\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0004\u000f"+
		"\u00d4\b\u000f\u000b\u000f\f\u000f\u00d5\u0003\u000f\u00d8\b\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0004\u0011\u00e2\b\u0011\u000b\u0011\f\u0011\u00e3"+
		"\u0003\u0011\u00e6\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0003\u0013\u00f4\b\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0003\u0014\u0100\b\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015"+
		"\u0109\b\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u010d\b\u0015\n\u0015"+
		"\f\u0015\u0110\t\u0015\u0001\u0015\u0000\u0001*\u0016\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \""+
		"$&(*\u0000\u0000\u011d\u0000,\u0001\u0000\u0000\u0000\u00028\u0001\u0000"+
		"\u0000\u0000\u0004<\u0001\u0000\u0000\u0000\u0006R\u0001\u0000\u0000\u0000"+
		"\bU\u0001\u0000\u0000\u0000\nh\u0001\u0000\u0000\u0000\fj\u0001\u0000"+
		"\u0000\u0000\u000ep\u0001\u0000\u0000\u0000\u0010z\u0001\u0000\u0000\u0000"+
		"\u0012\u0087\u0001\u0000\u0000\u0000\u0014\u009c\u0001\u0000\u0000\u0000"+
		"\u0016\u00a8\u0001\u0000\u0000\u0000\u0018\u00b6\u0001\u0000\u0000\u0000"+
		"\u001a\u00c8\u0001\u0000\u0000\u0000\u001c\u00ca\u0001\u0000\u0000\u0000"+
		"\u001e\u00d7\u0001\u0000\u0000\u0000 \u00d9\u0001\u0000\u0000\u0000\""+
		"\u00e5\u0001\u0000\u0000\u0000$\u00e7\u0001\u0000\u0000\u0000&\u00f3\u0001"+
		"\u0000\u0000\u0000(\u00ff\u0001\u0000\u0000\u0000*\u0108\u0001\u0000\u0000"+
		"\u0000,-\u0005\u0001\u0000\u0000-/\u0006\u0000\uffff\uffff\u0000.0\u0003"+
		"\u0002\u0001\u0000/.\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000\u0000"+
		"02\u0001\u0000\u0000\u000013\u0003\b\u0004\u000021\u0001\u0000\u0000\u0000"+
		"23\u0001\u0000\u0000\u000034\u0001\u0000\u0000\u000045\u0005\u0002\u0000"+
		"\u000056\u0006\u0000\uffff\uffff\u00006\u0001\u0001\u0000\u0000\u0000"+
		"79\u0003\u0004\u0002\u000087\u0001\u0000\u0000\u00009:\u0001\u0000\u0000"+
		"\u0000:8\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;\u0003\u0001"+
		"\u0000\u0000\u0000<=\u0003\u0006\u0003\u0000=>\u0005\u0018\u0000\u0000"+
		">D\u0006\u0002\uffff\uffff\u0000?@\u0005\u001d\u0000\u0000@A\u0005\u0018"+
		"\u0000\u0000AC\u0006\u0002\uffff\uffff\u0000B?\u0001\u0000\u0000\u0000"+
		"CF\u0001\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000"+
		"\u0000EG\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000GH\u0005\u001c"+
		"\u0000\u0000HI\u0006\u0002\uffff\uffff\u0000I\u0005\u0001\u0000\u0000"+
		"\u0000JK\u0005\u0003\u0000\u0000KS\u0006\u0003\uffff\uffff\u0000LM\u0005"+
		"\u0004\u0000\u0000MS\u0006\u0003\uffff\uffff\u0000NO\u0005\u0005\u0000"+
		"\u0000OS\u0006\u0003\uffff\uffff\u0000PQ\u0005\u0006\u0000\u0000QS\u0006"+
		"\u0003\uffff\uffff\u0000RJ\u0001\u0000\u0000\u0000RL\u0001\u0000\u0000"+
		"\u0000RN\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000S\u0007\u0001"+
		"\u0000\u0000\u0000TV\u0003\n\u0005\u0000UT\u0001\u0000\u0000\u0000VW\u0001"+
		"\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000"+
		"X\t\u0001\u0000\u0000\u0000YZ\u0003\f\u0006\u0000Z[\u0005\u001c\u0000"+
		"\u0000[i\u0001\u0000\u0000\u0000\\]\u0003\u000e\u0007\u0000]^\u0005\u001c"+
		"\u0000\u0000^i\u0001\u0000\u0000\u0000_`\u0003\u0010\b\u0000`a\u0005\u001c"+
		"\u0000\u0000ai\u0001\u0000\u0000\u0000bi\u0003\u0012\t\u0000ci\u0003\u0014"+
		"\n\u0000di\u0003\u0016\u000b\u0000ef\u0003\u001e\u000f\u0000fg\u0005\u001c"+
		"\u0000\u0000gi\u0001\u0000\u0000\u0000hY\u0001\u0000\u0000\u0000h\\\u0001"+
		"\u0000\u0000\u0000h_\u0001\u0000\u0000\u0000hb\u0001\u0000\u0000\u0000"+
		"hc\u0001\u0000\u0000\u0000hd\u0001\u0000\u0000\u0000he\u0001\u0000\u0000"+
		"\u0000i\u000b\u0001\u0000\u0000\u0000jk\u0005\u0007\u0000\u0000kl\u0005"+
		"\u001f\u0000\u0000lm\u0005\u0018\u0000\u0000mn\u0006\u0006\uffff\uffff"+
		"\u0000no\u0005 \u0000\u0000o\r\u0001\u0000\u0000\u0000pq\u0005\b\u0000"+
		"\u0000qv\u0005\u001f\u0000\u0000rs\u0005\u0014\u0000\u0000sw\u0006\u0007"+
		"\uffff\uffff\u0000tu\u0005\u0018\u0000\u0000uw\u0006\u0007\uffff\uffff"+
		"\u0000vr\u0001\u0000\u0000\u0000vt\u0001\u0000\u0000\u0000wx\u0001\u0000"+
		"\u0000\u0000xy\u0005 \u0000\u0000y\u000f\u0001\u0000\u0000\u0000z{\u0005"+
		"\u0018\u0000\u0000{|\u0006\b\uffff\uffff\u0000|\u0083\u0005\t\u0000\u0000"+
		"}~\u0005\u0017\u0000\u0000~\u0084\u0006\b\uffff\uffff\u0000\u007f\u0084"+
		"\u0003\u001e\u000f\u0000\u0080\u0084\u0003\u0018\f\u0000\u0081\u0082\u0005"+
		"\u0014\u0000\u0000\u0082\u0084\u0006\b\uffff\uffff\u0000\u0083}\u0001"+
		"\u0000\u0000\u0000\u0083\u007f\u0001\u0000\u0000\u0000\u0083\u0080\u0001"+
		"\u0000\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0084\u0085\u0001"+
		"\u0000\u0000\u0000\u0085\u0086\u0006\b\uffff\uffff\u0000\u0086\u0011\u0001"+
		"\u0000\u0000\u0000\u0087\u0088\u0005\n\u0000\u0000\u0088\u0089\u0006\t"+
		"\uffff\uffff\u0000\u0089\u008a\u0005\u001f\u0000\u0000\u008a\u008b\u0003"+
		"\u0018\f\u0000\u008b\u008c\u0005 \u0000\u0000\u008c\u008d\u0006\t\uffff"+
		"\uffff\u0000\u008d\u008e\u0005\u000b\u0000\u0000\u008e\u008f\u0003\b\u0004"+
		"\u0000\u008f\u0090\u0006\t\uffff\uffff\u0000\u0090\u0098\u0005\f\u0000"+
		"\u0000\u0091\u0092\u0005\r\u0000\u0000\u0092\u0093\u0005\u000b\u0000\u0000"+
		"\u0093\u0094\u0006\t\uffff\uffff\u0000\u0094\u0095\u0003\b\u0004\u0000"+
		"\u0095\u0096\u0006\t\uffff\uffff\u0000\u0096\u0097\u0005\f\u0000\u0000"+
		"\u0097\u0099\u0001\u0000\u0000\u0000\u0098\u0091\u0001\u0000\u0000\u0000"+
		"\u0098\u0099\u0001\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000"+
		"\u009a\u009b\u0006\t\uffff\uffff\u0000\u009b\u0013\u0001\u0000\u0000\u0000"+
		"\u009c\u009d\u0005\u000e\u0000\u0000\u009d\u009e\u0006\n\uffff\uffff\u0000"+
		"\u009e\u009f\u0005\u001f\u0000\u0000\u009f\u00a0\u0003\u0018\f\u0000\u00a0"+
		"\u00a1\u0005 \u0000\u0000\u00a1\u00a2\u0006\n\uffff\uffff\u0000\u00a2"+
		"\u00a3\u0005\u000b\u0000\u0000\u00a3\u00a4\u0003\b\u0004\u0000\u00a4\u00a5"+
		"\u0006\n\uffff\uffff\u0000\u00a5\u00a6\u0005\f\u0000\u0000\u00a6\u00a7"+
		"\u0006\n\uffff\uffff\u0000\u00a7\u0015\u0001\u0000\u0000\u0000\u00a8\u00a9"+
		"\u0005\u000f\u0000\u0000\u00a9\u00aa\u0006\u000b\uffff\uffff\u0000\u00aa"+
		"\u00ab\u0005\u000b\u0000\u0000\u00ab\u00ac\u0003\b\u0004\u0000\u00ac\u00ad"+
		"\u0006\u000b\uffff\uffff\u0000\u00ad\u00ae\u0005\f\u0000\u0000\u00ae\u00af"+
		"\u0005\u000e\u0000\u0000\u00af\u00b0\u0005\u001f\u0000\u0000\u00b0\u00b1"+
		"\u0003\u0018\f\u0000\u00b1\u00b2\u0005 \u0000\u0000\u00b2\u00b3\u0005"+
		"\u001c\u0000\u0000\u00b3\u00b4\u0006\u000b\uffff\uffff\u0000\u00b4\u00b5"+
		"\u0006\u000b\uffff\uffff\u0000\u00b5\u0017\u0001\u0000\u0000\u0000\u00b6"+
		"\u00be\u0003\u001a\r\u0000\u00b7\u00b8\u0005\u0013\u0000\u0000\u00b8\u00b9"+
		"\u0006\f\uffff\uffff\u0000\u00b9\u00ba\u0003\u001a\r\u0000\u00ba\u00bb"+
		"\u0006\f\uffff\uffff\u0000\u00bb\u00bd\u0001\u0000\u0000\u0000\u00bc\u00b7"+
		"\u0001\u0000\u0000\u0000\u00bd\u00c0\u0001\u0000\u0000\u0000\u00be\u00bc"+
		"\u0001\u0000\u0000\u0000\u00be\u00bf\u0001\u0000\u0000\u0000\u00bf\u0019"+
		"\u0001\u0000\u0000\u0000\u00c0\u00be\u0001\u0000\u0000\u0000\u00c1\u00c2"+
		"\u0005\u001f\u0000\u0000\u00c2\u00c3\u0003\u0018\f\u0000\u00c3\u00c4\u0005"+
		" \u0000\u0000\u00c4\u00c9\u0001\u0000\u0000\u0000\u00c5\u00c6\u0005\u0017"+
		"\u0000\u0000\u00c6\u00c9\u0006\r\uffff\uffff\u0000\u00c7\u00c9\u0003\u001c"+
		"\u000e\u0000\u00c8\u00c1\u0001\u0000\u0000\u0000\u00c8\u00c5\u0001\u0000"+
		"\u0000\u0000\u00c8\u00c7\u0001\u0000\u0000\u0000\u00c9\u001b\u0001\u0000"+
		"\u0000\u0000\u00ca\u00cb\u0003\u001e\u000f\u0000\u00cb\u00cc\u0005\u0012"+
		"\u0000\u0000\u00cc\u00cd\u0006\u000e\uffff\uffff\u0000\u00cd\u00ce\u0003"+
		"\u001e\u000f\u0000\u00ce\u00cf\u0006\u000e\uffff\uffff\u0000\u00cf\u001d"+
		"\u0001\u0000\u0000\u0000\u00d0\u00d8\u0003\"\u0011\u0000\u00d1\u00d3\u0003"+
		"\"\u0011\u0000\u00d2\u00d4\u0003 \u0010\u0000\u00d3\u00d2\u0001\u0000"+
		"\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5\u00d3\u0001\u0000"+
		"\u0000\u0000\u00d5\u00d6\u0001\u0000\u0000\u0000\u00d6\u00d8\u0001\u0000"+
		"\u0000\u0000\u00d7\u00d0\u0001\u0000\u0000\u0000\u00d7\u00d1\u0001\u0000"+
		"\u0000\u0000\u00d8\u001f\u0001\u0000\u0000\u0000\u00d9\u00da\u0005\u0010"+
		"\u0000\u0000\u00da\u00db\u0006\u0010\uffff\uffff\u0000\u00db\u00dc\u0003"+
		"\"\u0011\u0000\u00dc\u00dd\u0006\u0010\uffff\uffff\u0000\u00dd!\u0001"+
		"\u0000\u0000\u0000\u00de\u00e6\u0003&\u0013\u0000\u00df\u00e1\u0003&\u0013"+
		"\u0000\u00e0\u00e2\u0003$\u0012\u0000\u00e1\u00e0\u0001\u0000\u0000\u0000"+
		"\u00e2\u00e3\u0001\u0000\u0000\u0000\u00e3\u00e1\u0001\u0000\u0000\u0000"+
		"\u00e3\u00e4\u0001\u0000\u0000\u0000\u00e4\u00e6\u0001\u0000\u0000\u0000"+
		"\u00e5\u00de\u0001\u0000\u0000\u0000\u00e5\u00df\u0001\u0000\u0000\u0000"+
		"\u00e6#\u0001\u0000\u0000\u0000\u00e7\u00e8\u0005\u0011\u0000\u0000\u00e8"+
		"\u00e9\u0006\u0012\uffff\uffff\u0000\u00e9\u00ea\u0003&\u0013\u0000\u00ea"+
		"\u00eb\u0006\u0012\uffff\uffff\u0000\u00eb%\u0001\u0000\u0000\u0000\u00ec"+
		"\u00ed\u0005\u0018\u0000\u0000\u00ed\u00f4\u0006\u0013\uffff\uffff\u0000"+
		"\u00ee\u00f4\u0003(\u0014\u0000\u00ef\u00f0\u0005\u001f\u0000\u0000\u00f0"+
		"\u00f1\u0003\u001e\u000f\u0000\u00f1\u00f2\u0005 \u0000\u0000\u00f2\u00f4"+
		"\u0001\u0000\u0000\u0000\u00f3\u00ec\u0001\u0000\u0000\u0000\u00f3\u00ee"+
		"\u0001\u0000\u0000\u0000\u00f3\u00ef\u0001\u0000\u0000\u0000\u00f4\'\u0001"+
		"\u0000\u0000\u0000\u00f5\u00f6\u0005\u0015\u0000\u0000\u00f6\u0100\u0006"+
		"\u0014\uffff\uffff\u0000\u00f7\u00f8\u0005\u0016\u0000\u0000\u00f8\u0100"+
		"\u0006\u0014\uffff\uffff\u0000\u00f9\u00fa\u0005\u0019\u0000\u0000\u00fa"+
		"\u0100\u0006\u0014\uffff\uffff\u0000\u00fb\u00fc\u0005\u001a\u0000\u0000"+
		"\u00fc\u0100\u0006\u0014\uffff\uffff\u0000\u00fd\u00fe\u0005\u001b\u0000"+
		"\u0000\u00fe\u0100\u0006\u0014\uffff\uffff\u0000\u00ff\u00f5\u0001\u0000"+
		"\u0000\u0000\u00ff\u00f7\u0001\u0000\u0000\u0000\u00ff\u00f9\u0001\u0000"+
		"\u0000\u0000\u00ff\u00fb\u0001\u0000\u0000\u0000\u00ff\u00fd\u0001\u0000"+
		"\u0000\u0000\u0100)\u0001\u0000\u0000\u0000\u0101\u0102\u0006\u0015\uffff"+
		"\uffff\u0000\u0102\u0103\u0005\u001f\u0000\u0000\u0103\u0104\u0003*\u0015"+
		"\u0000\u0104\u0105\u0005 \u0000\u0000\u0105\u0109\u0001\u0000\u0000\u0000"+
		"\u0106\u0107\u0005\u001f\u0000\u0000\u0107\u0109\u0005 \u0000\u0000\u0108"+
		"\u0101\u0001\u0000\u0000\u0000\u0108\u0106\u0001\u0000\u0000\u0000\u0109"+
		"\u010e\u0001\u0000\u0000\u0000\u010a\u010b\n\u0001\u0000\u0000\u010b\u010d"+
		"\u0003*\u0015\u0002\u010c\u010a\u0001\u0000\u0000\u0000\u010d\u0110\u0001"+
		"\u0000\u0000\u0000\u010e\u010c\u0001\u0000\u0000\u0000\u010e\u010f\u0001"+
		"\u0000\u0000\u0000\u010f+\u0001\u0000\u0000\u0000\u0110\u010e\u0001\u0000"+
		"\u0000\u0000\u0014/2:DRWhv\u0083\u0098\u00be\u00c8\u00d5\u00d7\u00e3\u00e5"+
		"\u00f3\u00ff\u0108\u010e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}