// Generated from /media/maik/B4FA6A2DFA69EC54/Users/Windows  7/Desktop/UFABC/12° QUAD - LOADING/Compiladores - Isidro/Projeto/IsiCompiler/src/IsiLanguage.g4 by ANTLR 4.8
package parser;

    import datastructures.*;
    import exceptions.*;
    import ast.*;
    import util.*;
    import java.util.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IsiLanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, ID=14, AP=15, FP=16, ATR=17, OP=18, 
		NUM=19, TEXT=20, CMT=21, OPREL=22, LOP=23, AC=24, FC=25, WS=26, FIM=27, 
		VIR=28, SEMICOLON=29, UNARY=30;
	public static final int
		RULE_programa = 0, RULE_declara = 1, RULE_declaraVar = 2, RULE_tipo = 3, 
		RULE_bloco = 4, RULE_cmd = 5, RULE_cmdLeitura = 6, RULE_cmdEscrita = 7, 
		RULE_cmdAtr = 8, RULE_cmdIf = 9, RULE_cmdEnquanto = 10, RULE_cmdPara = 11, 
		RULE_cmdUnario = 12, RULE_cmdComentario = 13, RULE_cmdFacaEnquanto = 14, 
		RULE_conditional = 15, RULE_booleanExpr = 16, RULE_expr = 17, RULE_termo = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "declara", "declaraVar", "tipo", "bloco", "cmd", "cmdLeitura", 
			"cmdEscrita", "cmdAtr", "cmdIf", "cmdEnquanto", "cmdPara", "cmdUnario", 
			"cmdComentario", "cmdFacaEnquanto", "conditional", "booleanExpr", "expr", 
			"termo"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog'", "'numero'", "'texto'", "'leia'", "'escreva'", 
			"'se'", "'entao'", "'senao se'", "'senao'", "'enquanto'", "'para'", "'faca'", 
			null, "'('", "')'", "':='", null, null, null, null, null, null, "'{'", 
			"'}'", null, "'.'", "','", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "ID", "AP", "FP", "ATR", "OP", "NUM", "TEXT", "CMT", "OPREL", 
			"LOP", "AC", "FC", "WS", "FIM", "VIR", "SEMICOLON", "UNARY"
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
	public String getGrammarFileName() { return "IsiLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    private IsiType type;
	    private String value;
	    private IsiSymbolTable symbolTable = new IsiSymbolTable();
	    private IsiSymbol symbol;

	    private String _test;
	    
	    private String currentID;
	    private String content;
	    private IsiProgram program = new IsiProgram();
	    private List<AbstractCommand> currentThread;
	    private Stack<List<AbstractCommand>> stack = new Stack<>();

	    private List<AbstractCommand> trueList;
	    private List<AbstractCommand> falseList;

	    // Start - Expression validation related
	    private List<IsiType> expressionTypes;
	    private List<String> mathOperators;
	    private IsiType expressionIsiType;
	    private String assigningVariableID;

	    // Start - Unary operations related
	    private boolean isPostUnary;
	    // End - Unary operations related

	    public void setExpressionType() {
	        if (expressionTypes.contains(IsiType.TEXT)) {
	            expressionIsiType = IsiType.TEXT;
	            return;
	        }
	        expressionIsiType = IsiType.NUMBER;
	    }

	    public void verifyAssignmentType() {
	        IsiType variableType = getSymbolType(assigningVariableID);
	        if (variableType != expressionIsiType) {
	            throw new IsiSemanticException("Can't assign '" + expressionIsiType + "' to a '" + variableType + "' variable. Variable name: " + assigningVariableID);
	        }
	    }

	    public void verifyOperationValidity() {       
	        if (expressionIsiType == IsiType.NUMBER || mathOperators.size() == 0) {
	            return;
	        }


	        if (mathOperators.contains("-")) {
	            throw new IsiSemanticException("A TEXT expression cannot have a '-' operator.");
	        }

	        for (int i = 1; i < expressionTypes.size(); i++) {
	            if (!mathOperators.get(i -1).equals("+") && (expressionTypes.get(i) == IsiType.TEXT || expressionTypes.get(i - 1) == IsiType.TEXT)) {
	                throw new IsiSemanticException("Invalid operation.");
	            }
	        }
	    }
	    // End - Expression validation related
	    
	    public IsiType getSymbolType(String id) {
	        return ((IsiVariable) symbolTable.get(id)).getType();
	    }

	    public void addSymbol(String id, IsiType type, String value) {
	        if (symbolTable.contains(id)) {
	            throw new IsiSemanticException("Symbol '" + id + "' already declared.");
	        }

	        IsiSymbol newSymbol = new IsiVariable(id, type, value);
	        symbolTable.add(newSymbol);        
	    }

	    public void verifySymbolDeclaration(String id) {
	        if (!symbolTable.contains(id)) {
	            throw new IsiSemanticException("Symbol '" + id + "' wasn't declared.");            
	        }
	    }

	    public void setSymbolToBeInUse(String id) {
	        verifySymbolDeclaration(id);
	        IsiVariable variable = (IsiVariable) symbolTable.get(id);
	        variable.becomeInUse();
	        symbolTable.add(variable);
	    }

	    public void verifyIfAllVariablesAreInUse() {
	        Optional<IsiSymbol> variable = symbolTable.getSymbols().stream().filter(var -> !((IsiVariable) var).getIsBeingUsed()).findFirst();

	        if (variable.isPresent()) {
	            throw new IsiSemanticException("The varible  '" + variable.get().getName() + "' wasn't used.");
	        }
	    }

	    public void verifyType(String id, IsiType type) {
	        if (getSymbolType(id) != type) {
	            throw new IsiSemanticException("The variable is not a " + type);
	        }
	    }



	    public void generateProgram() {
	        program.generateProgram();
	    }

	    public void showCommands() {
	        for (AbstractCommand c : program.getCommands()) {
	            System.out.println(c);
	        }
	    }  
	    

	public IsiLanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramaContext extends ParserRuleContext {
		public DeclaraContext declara() {
			return getRuleContext(DeclaraContext.class,0);
		}
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public TerminalNode FIM() { return getToken(IsiLanguageParser.FIM, 0); }
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).exitPrograma(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			match(T__0);
			setState(39);
			declara();
			setState(40);
			bloco();
			setState(41);
			match(T__1);
			setState(42);
			match(FIM);

			                    verifyIfAllVariablesAreInUse();
			                    program.setSymbolTable(symbolTable);
			                    program.setCommands(stack.pop());
			                
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

	public static class DeclaraContext extends ParserRuleContext {
		public List<DeclaraVarContext> declaraVar() {
			return getRuleContexts(DeclaraVarContext.class);
		}
		public DeclaraVarContext declaraVar(int i) {
			return getRuleContext(DeclaraVarContext.class,i);
		}
		public DeclaraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declara; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).enterDeclara(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).exitDeclara(this);
		}
	}

	public final DeclaraContext declara() throws RecognitionException {
		DeclaraContext _localctx = new DeclaraContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declara);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(45);
				declaraVar();
				}
				}
				setState(48); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 || _la==T__3 );
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

	public static class DeclaraVarContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(IsiLanguageParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLanguageParser.ID, i);
		}
		public TerminalNode FIM() { return getToken(IsiLanguageParser.FIM, 0); }
		public List<TerminalNode> VIR() { return getTokens(IsiLanguageParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(IsiLanguageParser.VIR, i);
		}
		public DeclaraVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaraVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).enterDeclaraVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).exitDeclaraVar(this);
		}
	}

	public final DeclaraVarContext declaraVar() throws RecognitionException {
		DeclaraVarContext _localctx = new DeclaraVarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaraVar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			tipo();
			setState(51);
			match(ID);

			                    addSymbol(_input.LT(-1).getText(), type, null);
			                
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(53);
				match(VIR);
				setState(54);
				match(ID);

				                        addSymbol(_input.LT(-1).getText(), type, null);
				                    
				}
				}
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(61);
			match(FIM);
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

	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).exitTipo(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tipo);
		try {
			setState(67);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				match(T__2);
				 type = IsiType.NUMBER; 
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				match(T__3);
				 type = IsiType.TEXT; 
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
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).exitBloco(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

			                    currentThread = new ArrayList<>();
			                    stack.push(currentThread);        
			                
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << ID) | (1L << CMT) | (1L << FIM) | (1L << UNARY))) != 0)) {
				{
				{
				setState(70);
				cmd();
				}
				}
				setState(75);
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

	public static class CmdContext extends ParserRuleContext {
		public CmdLeituraContext cmdLeitura() {
			return getRuleContext(CmdLeituraContext.class,0);
		}
		public CmdEscritaContext cmdEscrita() {
			return getRuleContext(CmdEscritaContext.class,0);
		}
		public CmdAtrContext cmdAtr() {
			return getRuleContext(CmdAtrContext.class,0);
		}
		public CmdIfContext cmdIf() {
			return getRuleContext(CmdIfContext.class,0);
		}
		public CmdEnquantoContext cmdEnquanto() {
			return getRuleContext(CmdEnquantoContext.class,0);
		}
		public CmdParaContext cmdPara() {
			return getRuleContext(CmdParaContext.class,0);
		}
		public CmdUnarioContext cmdUnario() {
			return getRuleContext(CmdUnarioContext.class,0);
		}
		public CmdComentarioContext cmdComentario() {
			return getRuleContext(CmdComentarioContext.class,0);
		}
		public CmdFacaEnquantoContext cmdFacaEnquanto() {
			return getRuleContext(CmdFacaEnquantoContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).exitCmd(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmd);
		try {
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				cmdLeitura();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				cmdEscrita();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(78);
				cmdAtr();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(79);
				cmdIf();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(80);
				cmdEnquanto();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(81);
				cmdPara();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(82);
				cmdUnario();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(83);
				cmdComentario();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(84);
				cmdFacaEnquanto();
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

	public static class CmdLeituraContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLanguageParser.AP, 0); }
		public TerminalNode ID() { return getToken(IsiLanguageParser.ID, 0); }
		public TerminalNode FP() { return getToken(IsiLanguageParser.FP, 0); }
		public TerminalNode FIM() { return getToken(IsiLanguageParser.FIM, 0); }
		public CmdLeituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdLeitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).enterCmdLeitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).exitCmdLeitura(this);
		}
	}

	public final CmdLeituraContext cmdLeitura() throws RecognitionException {
		CmdLeituraContext _localctx = new CmdLeituraContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdLeitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(T__4);
			setState(88);
			match(AP);
			setState(89);
			match(ID);
			 
			                        currentID = _input.LT(-1).getText();
			                        verifySymbolDeclaration(currentID);
			                    
			setState(91);
			match(FP);
			setState(92);
			match(FIM);

			                    IsiVariable variable = (IsiVariable) symbolTable.get(currentID);
			                    CommandLeitura cmd = new CommandLeitura(currentID, variable);
			                    stack.peek().add(cmd);
			                    setSymbolToBeInUse(currentID);
			                
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

	public static class CmdEscritaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLanguageParser.AP, 0); }
		public TerminalNode ID() { return getToken(IsiLanguageParser.ID, 0); }
		public TerminalNode FP() { return getToken(IsiLanguageParser.FP, 0); }
		public TerminalNode FIM() { return getToken(IsiLanguageParser.FIM, 0); }
		public CmdEscritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdEscrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).enterCmdEscrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).exitCmdEscrita(this);
		}
	}

	public final CmdEscritaContext cmdEscrita() throws RecognitionException {
		CmdEscritaContext _localctx = new CmdEscritaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdEscrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(T__5);
			setState(96);
			match(AP);
			setState(97);
			match(ID);

			                    currentID = _input.LT(-1).getText();
			                    verifySymbolDeclaration(currentID);
			                
			setState(99);
			match(FP);
			setState(100);
			match(FIM);

			                    CommandEscrita cmd = new CommandEscrita(currentID);
			                    stack.peek().add(cmd);
			                    setSymbolToBeInUse(currentID);
			                
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

	public static class CmdAtrContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsiLanguageParser.ID, 0); }
		public TerminalNode ATR() { return getToken(IsiLanguageParser.ATR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FIM() { return getToken(IsiLanguageParser.FIM, 0); }
		public CmdAtrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdAtr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).enterCmdAtr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).exitCmdAtr(this);
		}
	}

	public final CmdAtrContext cmdAtr() throws RecognitionException {
		CmdAtrContext _localctx = new CmdAtrContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdAtr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(ID);

			                    currentID = _input.LT(-1).getText();
			                    assigningVariableID = currentID;
			                    verifySymbolDeclaration(currentID);
			                    expressionTypes = new ArrayList<>();
			                    mathOperators = new ArrayList<>();
			                
			setState(105);
			match(ATR);
			 content = ""; 
			setState(107);
			expr();

			                    setExpressionType();
			                    verifyAssignmentType();
			                    verifyOperationValidity();
			                
			setState(109);
			match(FIM);

			                    CommandAtribuicao cmd = new CommandAtribuicao(assigningVariableID, content);
			                    stack.peek().add(cmd);
			                    setSymbolToBeInUse(currentID);
			                    
			                
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

	public static class CmdIfContext extends ParserRuleContext {
		public List<TerminalNode> AP() { return getTokens(IsiLanguageParser.AP); }
		public TerminalNode AP(int i) {
			return getToken(IsiLanguageParser.AP, i);
		}
		public List<ConditionalContext> conditional() {
			return getRuleContexts(ConditionalContext.class);
		}
		public ConditionalContext conditional(int i) {
			return getRuleContext(ConditionalContext.class,i);
		}
		public List<TerminalNode> FP() { return getTokens(IsiLanguageParser.FP); }
		public TerminalNode FP(int i) {
			return getToken(IsiLanguageParser.FP, i);
		}
		public List<TerminalNode> AC() { return getTokens(IsiLanguageParser.AC); }
		public TerminalNode AC(int i) {
			return getToken(IsiLanguageParser.AC, i);
		}
		public List<TerminalNode> FC() { return getTokens(IsiLanguageParser.FC); }
		public TerminalNode FC(int i) {
			return getToken(IsiLanguageParser.FC, i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).enterCmdIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).exitCmdIf(this);
		}
	}

	public final CmdIfContext cmdIf() throws RecognitionException {
		CmdIfContext _localctx = new CmdIfContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdIf);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

			                    content = "";
			                    falseList = null;
			                
			setState(113);
			match(T__6);
			setState(114);
			match(AP);
			setState(115);
			conditional();
			setState(116);
			match(FP);
			setState(117);
			match(T__7);
			setState(118);
			match(AC);
			 
			                        currentThread = new ArrayList<>();
			                        stack.push(currentThread);
			                    
			setState(121); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(120);
				cmd();
				}
				}
				setState(123); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << ID) | (1L << CMT) | (1L << FIM) | (1L << UNARY))) != 0) );
			setState(125);
			match(FC);

			                        trueList = stack.pop();
			                    
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(127);
				match(T__8);
				setState(128);
				match(AP);
				setState(129);
				conditional();
				setState(130);
				match(FP);
				setState(131);
				match(AC);
				setState(133); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(132);
					cmd();
					}
					}
					setState(135); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << ID) | (1L << CMT) | (1L << FIM) | (1L << UNARY))) != 0) );
				setState(137);
				match(FC);
				}
				}
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(144);
				match(T__9);
				setState(145);
				match(AC);

				                        currentThread = new ArrayList<>();
				                        stack.push(currentThread);
				                    
				setState(148); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(147);
					cmd();
					}
					}
					setState(150); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << ID) | (1L << CMT) | (1L << FIM) | (1L << UNARY))) != 0) );
				setState(152);
				match(FC);

				                        falseList = stack.pop();
				                        CommandIf cmd = new CommandIf(content, trueList, falseList);
				                        stack.peek().add(cmd);
				                    
				}
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

	public static class CmdEnquantoContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLanguageParser.AP, 0); }
		public ConditionalContext conditional() {
			return getRuleContext(ConditionalContext.class,0);
		}
		public TerminalNode FP() { return getToken(IsiLanguageParser.FP, 0); }
		public TerminalNode AC() { return getToken(IsiLanguageParser.AC, 0); }
		public TerminalNode FC() { return getToken(IsiLanguageParser.FC, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdEnquantoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdEnquanto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).enterCmdEnquanto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).exitCmdEnquanto(this);
		}
	}

	public final CmdEnquantoContext cmdEnquanto() throws RecognitionException {
		CmdEnquantoContext _localctx = new CmdEnquantoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cmdEnquanto);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

			                    content = "";                    
			                
			setState(158);
			match(T__10);
			setState(159);
			match(AP);
			setState(160);
			conditional();
			setState(161);
			match(FP);
			setState(162);
			match(AC);

			                        currentThread = new ArrayList<>();
			                        stack.push(currentThread);
			                    
			setState(165); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(164);
				cmd();
				}
				}
				setState(167); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << ID) | (1L << CMT) | (1L << FIM) | (1L << UNARY))) != 0) );
			setState(169);
			match(FC);

			                    CommandEnquanto enquanto = new CommandEnquanto(content, stack.pop());
			                    stack.peek().add(enquanto);
			                
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

	public static class CmdParaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLanguageParser.AP, 0); }
		public List<TerminalNode> SEMICOLON() { return getTokens(IsiLanguageParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(IsiLanguageParser.SEMICOLON, i);
		}
		public ConditionalContext conditional() {
			return getRuleContext(ConditionalContext.class,0);
		}
		public TerminalNode FP() { return getToken(IsiLanguageParser.FP, 0); }
		public TerminalNode AC() { return getToken(IsiLanguageParser.AC, 0); }
		public TerminalNode FC() { return getToken(IsiLanguageParser.FC, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public List<CmdAtrContext> cmdAtr() {
			return getRuleContexts(CmdAtrContext.class);
		}
		public CmdAtrContext cmdAtr(int i) {
			return getRuleContext(CmdAtrContext.class,i);
		}
		public List<TerminalNode> VIR() { return getTokens(IsiLanguageParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(IsiLanguageParser.VIR, i);
		}
		public CmdParaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdPara; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).enterCmdPara(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).exitCmdPara(this);
		}
	}

	public final CmdParaContext cmdPara() throws RecognitionException {
		CmdParaContext _localctx = new CmdParaContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cmdPara);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(T__11);
			setState(173);
			match(AP);
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				{
				setState(174);
				cmdAtr();
				}
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==VIR) {
					{
					{
					setState(175);
					match(VIR);
					setState(176);
					cmdAtr();
					}
					}
					setState(181);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(187);
			match(SEMICOLON);
			setState(188);
			conditional();
			setState(189);
			match(SEMICOLON);
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				{
				setState(190);
				cmdAtr();
				}
				setState(195);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==VIR) {
					{
					{
					setState(191);
					match(VIR);
					setState(192);
					cmdAtr();
					}
					}
					setState(197);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(203);
			match(FP);
			setState(204);
			match(AC);
			setState(206); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(205);
				cmd();
				}
				}
				setState(208); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << ID) | (1L << CMT) | (1L << FIM) | (1L << UNARY))) != 0) );
			setState(210);
			match(FC);
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

	public static class CmdUnarioContext extends ParserRuleContext {
		public TerminalNode FIM() { return getToken(IsiLanguageParser.FIM, 0); }
		public List<TerminalNode> ID() { return getTokens(IsiLanguageParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLanguageParser.ID, i);
		}
		public List<TerminalNode> UNARY() { return getTokens(IsiLanguageParser.UNARY); }
		public TerminalNode UNARY(int i) {
			return getToken(IsiLanguageParser.UNARY, i);
		}
		public CmdUnarioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdUnario; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).enterCmdUnario(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).exitCmdUnario(this);
		}
	}

	public final CmdUnarioContext cmdUnario() throws RecognitionException {
		CmdUnarioContext _localctx = new CmdUnarioContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_cmdUnario);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID || _la==UNARY) {
				{
				setState(220);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(212);
					match(ID);
					 
					                            currentID = _input.LT(-1).getText();
					                            verifySymbolDeclaration(currentID);
					                            verifyType(currentID, IsiType.NUMBER);                            
					                        
					setState(214);
					match(UNARY);

					                            content = _input.LT(-1).getText(); 
					                            isPostUnary = true;
					}
					break;
				case UNARY:
					{
					setState(216);
					match(UNARY);

					                            content = _input.LT(-1).getText();
					                            isPostUnary = false;
					                        
					setState(218);
					match(ID);
					 
					                            currentID = _input.LT(-1).getText();
					                            verifySymbolDeclaration(currentID);
					                            verifyType(currentID, IsiType.NUMBER);
					                        
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(225);
			match(FIM);

			                    CommandUnary cmdUn = new CommandUnary(content, currentID, isPostUnary);
			                    stack.peek().add(cmdUn);
			                
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

	public static class CmdComentarioContext extends ParserRuleContext {
		public TerminalNode CMT() { return getToken(IsiLanguageParser.CMT, 0); }
		public CmdComentarioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdComentario; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).enterCmdComentario(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).exitCmdComentario(this);
		}
	}

	public final CmdComentarioContext cmdComentario() throws RecognitionException {
		CmdComentarioContext _localctx = new CmdComentarioContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_cmdComentario);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(CMT);

			                        CommandComentario cmdComentario = new CommandComentario(_input.LT(-1).getText());
			                        stack.peek().add(cmdComentario);
			                    
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

	public static class CmdFacaEnquantoContext extends ParserRuleContext {
		public TerminalNode AC() { return getToken(IsiLanguageParser.AC, 0); }
		public TerminalNode FC() { return getToken(IsiLanguageParser.FC, 0); }
		public TerminalNode AP() { return getToken(IsiLanguageParser.AP, 0); }
		public ConditionalContext conditional() {
			return getRuleContext(ConditionalContext.class,0);
		}
		public TerminalNode FP() { return getToken(IsiLanguageParser.FP, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdFacaEnquantoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdFacaEnquanto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).enterCmdFacaEnquanto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).exitCmdFacaEnquanto(this);
		}
	}

	public final CmdFacaEnquantoContext cmdFacaEnquanto() throws RecognitionException {
		CmdFacaEnquantoContext _localctx = new CmdFacaEnquantoContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_cmdFacaEnquanto);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

			                            content = "";
			                        
			setState(232);
			match(T__12);
			setState(233);
			match(AC);

			                                currentThread = new ArrayList<>();
			                                stack.push(currentThread);
			                            
			setState(238);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << ID) | (1L << CMT) | (1L << FIM) | (1L << UNARY))) != 0)) {
				{
				{
				setState(235);
				cmd();
				}
				}
				setState(240);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(241);
			match(FC);
			setState(242);
			match(T__10);
			setState(243);
			match(AP);
			setState(244);
			conditional();
			setState(245);
			match(FP);

			                            List<AbstractCommand> commands = stack.pop();
			                            CommandFacaEnquanto cfe = new CommandFacaEnquanto(content, commands);
			                            stack.peek().add(cfe);                            
			                        
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

	public static class ConditionalContext extends ParserRuleContext {
		public List<BooleanExprContext> booleanExpr() {
			return getRuleContexts(BooleanExprContext.class);
		}
		public BooleanExprContext booleanExpr(int i) {
			return getRuleContext(BooleanExprContext.class,i);
		}
		public List<TerminalNode> OPREL() { return getTokens(IsiLanguageParser.OPREL); }
		public TerminalNode OPREL(int i) {
			return getToken(IsiLanguageParser.OPREL, i);
		}
		public List<TerminalNode> LOP() { return getTokens(IsiLanguageParser.LOP); }
		public TerminalNode LOP(int i) {
			return getToken(IsiLanguageParser.LOP, i);
		}
		public ConditionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).enterConditional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).exitConditional(this);
		}
	}

	public final ConditionalContext conditional() throws RecognitionException {
		ConditionalContext _localctx = new ConditionalContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_conditional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << NUM) | (1L << TEXT))) != 0)) {
				{
				{
				{
				setState(248);
				booleanExpr();
				setState(249);
				match(OPREL);
				content += _input.LT(-1).getText();
				setState(251);
				booleanExpr();
				}
				setState(262);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LOP) {
					{
					{
					setState(253);
					match(LOP);
					content += _input.LT(-1).getText();
					setState(255);
					booleanExpr();
					setState(256);
					match(OPREL);
					content += _input.LT(-1).getText();
					setState(258);
					booleanExpr();
					}
					}
					setState(264);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(269);
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

	public static class BooleanExprContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BooleanExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).enterBooleanExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).exitBooleanExpr(this);
		}
	}

	public final BooleanExprContext booleanExpr() throws RecognitionException {
		BooleanExprContext _localctx = new BooleanExprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_booleanExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{

			                expressionTypes = new ArrayList<>();
			            
			setState(271);
			expr();

			                setExpressionType();
			                System.out.println(expressionTypes);
			                System.out.println(_input.LT(-1).getText());
			                if (expressionIsiType != IsiType.NUMBER) {
			                    throw new IsiSemanticException("A boolean expression can only contain subexpressions of type NUMBER");
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

	public static class ExprContext extends ParserRuleContext {
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public List<TerminalNode> OP() { return getTokens(IsiLanguageParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(IsiLanguageParser.OP, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			termo();
			setState(280);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(275);
				match(OP);

				                        content += _input.LT(-1).getText();
				                        mathOperators.add(_input.LT(-1).getText());
				                    
				setState(277);
				termo();
				}
				}
				setState(282);
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

	public static class TermoContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(IsiLanguageParser.NUM, 0); }
		public TerminalNode TEXT() { return getToken(IsiLanguageParser.TEXT, 0); }
		public TerminalNode ID() { return getToken(IsiLanguageParser.ID, 0); }
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_termo);
		try {
			setState(289);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(283);
				match(NUM);
				 
				                    content += _input.LT(-1).getText(); 
				                    expressionTypes.add(IsiType.NUMBER);
				                
				}
				break;
			case TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(285);
				match(TEXT);
				 
				                    content += _input.LT(-1).getText();
				                    expressionTypes.add(IsiType.TEXT);
				                
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(287);
				match(ID);
				                
				                    currentID = _input.LT(-1).getText();
				                    verifySymbolDeclaration(currentID);
				                    setSymbolToBeInUse(currentID);
				                    content += currentID;
				                    expressionTypes.add(getSymbolType(currentID));
				                
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3 \u0126\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\6\3\61\n\3\r\3\16"+
		"\3\62\3\4\3\4\3\4\3\4\3\4\3\4\7\4;\n\4\f\4\16\4>\13\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\5\5F\n\5\3\6\3\6\7\6J\n\6\f\6\16\6M\13\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\5\7X\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\6\13|\n\13\r\13\16\13}\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\6\13\u0088\n\13\r\13\16\13\u0089\3\13\3\13\7\13"+
		"\u008e\n\13\f\13\16\13\u0091\13\13\3\13\3\13\3\13\3\13\6\13\u0097\n\13"+
		"\r\13\16\13\u0098\3\13\3\13\3\13\5\13\u009e\n\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\6\f\u00a8\n\f\r\f\16\f\u00a9\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3"+
		"\r\7\r\u00b4\n\r\f\r\16\r\u00b7\13\r\7\r\u00b9\n\r\f\r\16\r\u00bc\13\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00c4\n\r\f\r\16\r\u00c7\13\r\7\r\u00c9\n"+
		"\r\f\r\16\r\u00cc\13\r\3\r\3\r\3\r\6\r\u00d1\n\r\r\r\16\r\u00d2\3\r\3"+
		"\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00df\n\16\f\16\16\16"+
		"\u00e2\13\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\7"+
		"\20\u00ef\n\20\f\20\16\20\u00f2\13\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u0107"+
		"\n\21\f\21\16\21\u010a\13\21\7\21\u010c\n\21\f\21\16\21\u010f\13\21\3"+
		"\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\7\23\u0119\n\23\f\23\16\23\u011c"+
		"\13\23\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0124\n\24\3\24\2\2\25\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&\2\2\2\u0131\2(\3\2\2\2\4\60\3\2"+
		"\2\2\6\64\3\2\2\2\bE\3\2\2\2\nG\3\2\2\2\fW\3\2\2\2\16Y\3\2\2\2\20a\3\2"+
		"\2\2\22i\3\2\2\2\24r\3\2\2\2\26\u009f\3\2\2\2\30\u00ae\3\2\2\2\32\u00e0"+
		"\3\2\2\2\34\u00e6\3\2\2\2\36\u00e9\3\2\2\2 \u010d\3\2\2\2\"\u0110\3\2"+
		"\2\2$\u0114\3\2\2\2&\u0123\3\2\2\2()\7\3\2\2)*\5\4\3\2*+\5\n\6\2+,\7\4"+
		"\2\2,-\7\35\2\2-.\b\2\1\2.\3\3\2\2\2/\61\5\6\4\2\60/\3\2\2\2\61\62\3\2"+
		"\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63\5\3\2\2\2\64\65\5\b\5\2\65\66\7\20"+
		"\2\2\66<\b\4\1\2\678\7\36\2\289\7\20\2\29;\b\4\1\2:\67\3\2\2\2;>\3\2\2"+
		"\2<:\3\2\2\2<=\3\2\2\2=?\3\2\2\2><\3\2\2\2?@\7\35\2\2@\7\3\2\2\2AB\7\5"+
		"\2\2BF\b\5\1\2CD\7\6\2\2DF\b\5\1\2EA\3\2\2\2EC\3\2\2\2F\t\3\2\2\2GK\b"+
		"\6\1\2HJ\5\f\7\2IH\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2L\13\3\2\2\2M"+
		"K\3\2\2\2NX\5\16\b\2OX\5\20\t\2PX\5\22\n\2QX\5\24\13\2RX\5\26\f\2SX\5"+
		"\30\r\2TX\5\32\16\2UX\5\34\17\2VX\5\36\20\2WN\3\2\2\2WO\3\2\2\2WP\3\2"+
		"\2\2WQ\3\2\2\2WR\3\2\2\2WS\3\2\2\2WT\3\2\2\2WU\3\2\2\2WV\3\2\2\2X\r\3"+
		"\2\2\2YZ\7\7\2\2Z[\7\21\2\2[\\\7\20\2\2\\]\b\b\1\2]^\7\22\2\2^_\7\35\2"+
		"\2_`\b\b\1\2`\17\3\2\2\2ab\7\b\2\2bc\7\21\2\2cd\7\20\2\2de\b\t\1\2ef\7"+
		"\22\2\2fg\7\35\2\2gh\b\t\1\2h\21\3\2\2\2ij\7\20\2\2jk\b\n\1\2kl\7\23\2"+
		"\2lm\b\n\1\2mn\5$\23\2no\b\n\1\2op\7\35\2\2pq\b\n\1\2q\23\3\2\2\2rs\b"+
		"\13\1\2st\7\t\2\2tu\7\21\2\2uv\5 \21\2vw\7\22\2\2wx\7\n\2\2xy\7\32\2\2"+
		"y{\b\13\1\2z|\5\f\7\2{z\3\2\2\2|}\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\177\3\2"+
		"\2\2\177\u0080\7\33\2\2\u0080\u008f\b\13\1\2\u0081\u0082\7\13\2\2\u0082"+
		"\u0083\7\21\2\2\u0083\u0084\5 \21\2\u0084\u0085\7\22\2\2\u0085\u0087\7"+
		"\32\2\2\u0086\u0088\5\f\7\2\u0087\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089"+
		"\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\7\33"+
		"\2\2\u008c\u008e\3\2\2\2\u008d\u0081\3\2\2\2\u008e\u0091\3\2\2\2\u008f"+
		"\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u009d\3\2\2\2\u0091\u008f\3\2"+
		"\2\2\u0092\u0093\7\f\2\2\u0093\u0094\7\32\2\2\u0094\u0096\b\13\1\2\u0095"+
		"\u0097\5\f\7\2\u0096\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0096\3\2"+
		"\2\2\u0098\u0099\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b\7\33\2\2\u009b"+
		"\u009c\b\13\1\2\u009c\u009e\3\2\2\2\u009d\u0092\3\2\2\2\u009d\u009e\3"+
		"\2\2\2\u009e\25\3\2\2\2\u009f\u00a0\b\f\1\2\u00a0\u00a1\7\r\2\2\u00a1"+
		"\u00a2\7\21\2\2\u00a2\u00a3\5 \21\2\u00a3\u00a4\7\22\2\2\u00a4\u00a5\7"+
		"\32\2\2\u00a5\u00a7\b\f\1\2\u00a6\u00a8\5\f\7\2\u00a7\u00a6\3\2\2\2\u00a8"+
		"\u00a9\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\3\2"+
		"\2\2\u00ab\u00ac\7\33\2\2\u00ac\u00ad\b\f\1\2\u00ad\27\3\2\2\2\u00ae\u00af"+
		"\7\16\2\2\u00af\u00ba\7\21\2\2\u00b0\u00b5\5\22\n\2\u00b1\u00b2\7\36\2"+
		"\2\u00b2\u00b4\5\22\n\2\u00b3\u00b1\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5"+
		"\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b9\3\2\2\2\u00b7\u00b5\3\2"+
		"\2\2\u00b8\u00b0\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba"+
		"\u00bb\3\2\2\2\u00bb\u00bd\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd\u00be\7\37"+
		"\2\2\u00be\u00bf\5 \21\2\u00bf\u00ca\7\37\2\2\u00c0\u00c5\5\22\n\2\u00c1"+
		"\u00c2\7\36\2\2\u00c2\u00c4\5\22\n\2\u00c3\u00c1\3\2\2\2\u00c4\u00c7\3"+
		"\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7"+
		"\u00c5\3\2\2\2\u00c8\u00c0\3\2\2\2\u00c9\u00cc\3\2\2\2\u00ca\u00c8\3\2"+
		"\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cd\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd"+
		"\u00ce\7\22\2\2\u00ce\u00d0\7\32\2\2\u00cf\u00d1\5\f\7\2\u00d0\u00cf\3"+
		"\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3"+
		"\u00d4\3\2\2\2\u00d4\u00d5\7\33\2\2\u00d5\31\3\2\2\2\u00d6\u00d7\7\20"+
		"\2\2\u00d7\u00d8\b\16\1\2\u00d8\u00d9\7 \2\2\u00d9\u00df\b\16\1\2\u00da"+
		"\u00db\7 \2\2\u00db\u00dc\b\16\1\2\u00dc\u00dd\7\20\2\2\u00dd\u00df\b"+
		"\16\1\2\u00de\u00d6\3\2\2\2\u00de\u00da\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0"+
		"\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e3\3\2\2\2\u00e2\u00e0\3\2"+
		"\2\2\u00e3\u00e4\7\35\2\2\u00e4\u00e5\b\16\1\2\u00e5\33\3\2\2\2\u00e6"+
		"\u00e7\7\27\2\2\u00e7\u00e8\b\17\1\2\u00e8\35\3\2\2\2\u00e9\u00ea\b\20"+
		"\1\2\u00ea\u00eb\7\17\2\2\u00eb\u00ec\7\32\2\2\u00ec\u00f0\b\20\1\2\u00ed"+
		"\u00ef\5\f\7\2\u00ee\u00ed\3\2\2\2\u00ef\u00f2\3\2\2\2\u00f0\u00ee\3\2"+
		"\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f3\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f3"+
		"\u00f4\7\33\2\2\u00f4\u00f5\7\r\2\2\u00f5\u00f6\7\21\2\2\u00f6\u00f7\5"+
		" \21\2\u00f7\u00f8\7\22\2\2\u00f8\u00f9\b\20\1\2\u00f9\37\3\2\2\2\u00fa"+
		"\u00fb\5\"\22\2\u00fb\u00fc\7\30\2\2\u00fc\u00fd\b\21\1\2\u00fd\u00fe"+
		"\5\"\22\2\u00fe\u0108\3\2\2\2\u00ff\u0100\7\31\2\2\u0100\u0101\b\21\1"+
		"\2\u0101\u0102\5\"\22\2\u0102\u0103\7\30\2\2\u0103\u0104\b\21\1\2\u0104"+
		"\u0105\5\"\22\2\u0105\u0107\3\2\2\2\u0106\u00ff\3\2\2\2\u0107\u010a\3"+
		"\2\2\2\u0108\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010c\3\2\2\2\u010a"+
		"\u0108\3\2\2\2\u010b\u00fa\3\2\2\2\u010c\u010f\3\2\2\2\u010d\u010b\3\2"+
		"\2\2\u010d\u010e\3\2\2\2\u010e!\3\2\2\2\u010f\u010d\3\2\2\2\u0110\u0111"+
		"\b\22\1\2\u0111\u0112\5$\23\2\u0112\u0113\b\22\1\2\u0113#\3\2\2\2\u0114"+
		"\u011a\5&\24\2\u0115\u0116\7\24\2\2\u0116\u0117\b\23\1\2\u0117\u0119\5"+
		"&\24\2\u0118\u0115\3\2\2\2\u0119\u011c\3\2\2\2\u011a\u0118\3\2\2\2\u011a"+
		"\u011b\3\2\2\2\u011b%\3\2\2\2\u011c\u011a\3\2\2\2\u011d\u011e\7\25\2\2"+
		"\u011e\u0124\b\24\1\2\u011f\u0120\7\26\2\2\u0120\u0124\b\24\1\2\u0121"+
		"\u0122\7\20\2\2\u0122\u0124\b\24\1\2\u0123\u011d\3\2\2\2\u0123\u011f\3"+
		"\2\2\2\u0123\u0121\3\2\2\2\u0124\'\3\2\2\2\31\62<EKW}\u0089\u008f\u0098"+
		"\u009d\u00a9\u00b5\u00ba\u00c5\u00ca\u00d2\u00de\u00e0\u00f0\u0108\u010d"+
		"\u011a\u0123";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}