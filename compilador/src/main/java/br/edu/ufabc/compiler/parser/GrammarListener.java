// Generated from Grammar.g4 by ANTLR 4.13.0
package br.edu.ufabc.compiler.parser;

	import java.util.*;
	import br.edu.ufabc.compiler.ast.*;
	import br.edu.ufabc.compiler.symbols.*;
	import br.edu.ufabc.compiler.expression.*;
	import br.edu.ufabc.compiler.exception.*;


import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(GrammarParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(GrammarParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#declara}.
	 * @param ctx the parse tree
	 */
	void enterDeclara(GrammarParser.DeclaraContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#declara}.
	 * @param ctx the parse tree
	 */
	void exitDeclara(GrammarParser.DeclaraContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void enterDeclaravar(GrammarParser.DeclaravarContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void exitDeclaravar(GrammarParser.DeclaravarContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(GrammarParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(GrammarParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(GrammarParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(GrammarParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(GrammarParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(GrammarParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#cmdLeitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdLeitura(GrammarParser.CmdLeituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#cmdLeitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdLeitura(GrammarParser.CmdLeituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#cmdEscrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdEscrita(GrammarParser.CmdEscritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#cmdEscrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdEscrita(GrammarParser.CmdEscritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#cmdAttr}.
	 * @param ctx the parse tree
	 */
	void enterCmdAttr(GrammarParser.CmdAttrContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#cmdAttr}.
	 * @param ctx the parse tree
	 */
	void exitCmdAttr(GrammarParser.CmdAttrContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#cmdIf}.
	 * @param ctx the parse tree
	 */
	void enterCmdIf(GrammarParser.CmdIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#cmdIf}.
	 * @param ctx the parse tree
	 */
	void exitCmdIf(GrammarParser.CmdIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#cmdWhile}.
	 * @param ctx the parse tree
	 */
	void enterCmdWhile(GrammarParser.CmdWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#cmdWhile}.
	 * @param ctx the parse tree
	 */
	void exitCmdWhile(GrammarParser.CmdWhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#cmdDoWhile}.
	 * @param ctx the parse tree
	 */
	void enterCmdDoWhile(GrammarParser.CmdDoWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#cmdDoWhile}.
	 * @param ctx the parse tree
	 */
	void exitCmdDoWhile(GrammarParser.CmdDoWhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#exprBool}.
	 * @param ctx the parse tree
	 */
	void enterExprBool(GrammarParser.ExprBoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#exprBool}.
	 * @param ctx the parse tree
	 */
	void exitExprBool(GrammarParser.ExprBoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#exprBooll}.
	 * @param ctx the parse tree
	 */
	void enterExprBooll(GrammarParser.ExprBoollContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#exprBooll}.
	 * @param ctx the parse tree
	 */
	void exitExprBooll(GrammarParser.ExprBoollContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#exprRel}.
	 * @param ctx the parse tree
	 */
	void enterExprRel(GrammarParser.ExprRelContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#exprRel}.
	 * @param ctx the parse tree
	 */
	void exitExprRel(GrammarParser.ExprRelContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(GrammarParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(GrammarParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#exprl}.
	 * @param ctx the parse tree
	 */
	void enterExprl(GrammarParser.ExprlContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#exprl}.
	 * @param ctx the parse tree
	 */
	void exitExprl(GrammarParser.ExprlContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(GrammarParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(GrammarParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#termol}.
	 * @param ctx the parse tree
	 */
	void enterTermol(GrammarParser.TermolContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#termol}.
	 * @param ctx the parse tree
	 */
	void exitTermol(GrammarParser.TermolContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterFator(GrammarParser.FatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitFator(GrammarParser.FatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#num}.
	 * @param ctx the parse tree
	 */
	void enterNum(GrammarParser.NumContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#num}.
	 * @param ctx the parse tree
	 */
	void exitNum(GrammarParser.NumContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#balancedParentheses}.
	 * @param ctx the parse tree
	 */
	void enterBalancedParentheses(GrammarParser.BalancedParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#balancedParentheses}.
	 * @param ctx the parse tree
	 */
	void exitBalancedParentheses(GrammarParser.BalancedParenthesesContext ctx);
}