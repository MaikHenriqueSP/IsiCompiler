// Generated from /media/maik/B4FA6A2DFA69EC54/Users/Windows  7/Desktop/UFABC/12° QUAD - LOADING/Compiladores - Isidro/Projeto/IsiCompiler/src/IsiLanguage.g4 by ANTLR 4.8
package parser;

    import datastructures.*;
    import exceptions.*;
    import ast.*;
    import util.*;
    import java.util.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link IsiLanguageParser}.
 */
public interface IsiLanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link IsiLanguageParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(IsiLanguageParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLanguageParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(IsiLanguageParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLanguageParser#declara}.
	 * @param ctx the parse tree
	 */
	void enterDeclara(IsiLanguageParser.DeclaraContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLanguageParser#declara}.
	 * @param ctx the parse tree
	 */
	void exitDeclara(IsiLanguageParser.DeclaraContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLanguageParser#declaraVar}.
	 * @param ctx the parse tree
	 */
	void enterDeclaraVar(IsiLanguageParser.DeclaraVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLanguageParser#declaraVar}.
	 * @param ctx the parse tree
	 */
	void exitDeclaraVar(IsiLanguageParser.DeclaraVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLanguageParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(IsiLanguageParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLanguageParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(IsiLanguageParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLanguageParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(IsiLanguageParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLanguageParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(IsiLanguageParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLanguageParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(IsiLanguageParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLanguageParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(IsiLanguageParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLanguageParser#cmdLeitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdLeitura(IsiLanguageParser.CmdLeituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLanguageParser#cmdLeitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdLeitura(IsiLanguageParser.CmdLeituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLanguageParser#cmdEscrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdEscrita(IsiLanguageParser.CmdEscritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLanguageParser#cmdEscrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdEscrita(IsiLanguageParser.CmdEscritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLanguageParser#cmdAtr}.
	 * @param ctx the parse tree
	 */
	void enterCmdAtr(IsiLanguageParser.CmdAtrContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLanguageParser#cmdAtr}.
	 * @param ctx the parse tree
	 */
	void exitCmdAtr(IsiLanguageParser.CmdAtrContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLanguageParser#cmdIf}.
	 * @param ctx the parse tree
	 */
	void enterCmdIf(IsiLanguageParser.CmdIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLanguageParser#cmdIf}.
	 * @param ctx the parse tree
	 */
	void exitCmdIf(IsiLanguageParser.CmdIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLanguageParser#cmdEnquanto}.
	 * @param ctx the parse tree
	 */
	void enterCmdEnquanto(IsiLanguageParser.CmdEnquantoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLanguageParser#cmdEnquanto}.
	 * @param ctx the parse tree
	 */
	void exitCmdEnquanto(IsiLanguageParser.CmdEnquantoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLanguageParser#cmdPara}.
	 * @param ctx the parse tree
	 */
	void enterCmdPara(IsiLanguageParser.CmdParaContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLanguageParser#cmdPara}.
	 * @param ctx the parse tree
	 */
	void exitCmdPara(IsiLanguageParser.CmdParaContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLanguageParser#cmdUnario}.
	 * @param ctx the parse tree
	 */
	void enterCmdUnario(IsiLanguageParser.CmdUnarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLanguageParser#cmdUnario}.
	 * @param ctx the parse tree
	 */
	void exitCmdUnario(IsiLanguageParser.CmdUnarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLanguageParser#conditional}.
	 * @param ctx the parse tree
	 */
	void enterConditional(IsiLanguageParser.ConditionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLanguageParser#conditional}.
	 * @param ctx the parse tree
	 */
	void exitConditional(IsiLanguageParser.ConditionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(IsiLanguageParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(IsiLanguageParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLanguageParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(IsiLanguageParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLanguageParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(IsiLanguageParser.TermoContext ctx);
}