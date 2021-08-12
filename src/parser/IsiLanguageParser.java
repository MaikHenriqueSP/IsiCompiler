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
		T__9=10, T__10=11, T__11=12, ID=13, AP=14, FP=15, ATR=16, OP=17, NUM=18, 
		TEXT=19, OPREL=20, LOP=21, AC=22, FC=23, WS=24, FIM=25, VIR=26, SEMICOLON=27, 
		UNARY=28;
	public static final int
		RULE_programa = 0, RULE_declara = 1, RULE_declaraVar = 2, RULE_tipo = 3, 
		RULE_bloco = 4, RULE_cmd = 5, RULE_cmdLeitura = 6, RULE_cmdEscrita = 7, 
		RULE_cmdAtr = 8, RULE_cmdIf = 9, RULE_cmdEnquanto = 10, RULE_cmdPara = 11, 
		RULE_cmdUnario = 12, RULE_conditional = 13, RULE_expr = 14, RULE_termo = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "declara", "declaraVar", "tipo", "bloco", "cmd", "cmdLeitura", 
			"cmdEscrita", "cmdAtr", "cmdIf", "cmdEnquanto", "cmdPara", "cmdUnario", 
			"conditional", "expr", "termo"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog'", "'numero'", "'texto'", "'leia'", "'escreva'", 
			"'se'", "'entao'", "'senao se'", "'senao'", "'enquanto'", "'para'", null, 
			"'('", "')'", "':='", null, null, null, null, null, "'{'", "'}'", null, 
			"'.'", "','", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "ID", "AP", "FP", "ATR", "OP", "NUM", "TEXT", "OPREL", "LOP", "AC", 
			"FC", "WS", "FIM", "VIR", "SEMICOLON", "UNARY"
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
			setState(32);
			match(T__0);
			setState(33);
			declara();
			setState(34);
			bloco();
			setState(35);
			match(T__1);
			setState(36);
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
			setState(40); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(39);
				declaraVar();
				}
				}
				setState(42); 
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
			setState(44);
			tipo();
			setState(45);
			match(ID);

			                    addSymbol(_input.LT(-1).getText(), type, null);
			                
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(47);
				match(VIR);
				setState(48);
				match(ID);

				                        addSymbol(_input.LT(-1).getText(), type, null);
				                    
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(55);
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
			setState(61);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				match(T__2);
				 type = IsiType.NUMBER; 
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
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
			                
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__10) | (1L << T__11) | (1L << ID) | (1L << FIM) | (1L << UNARY))) != 0)) {
				{
				{
				setState(64);
				cmd();
				}
				}
				setState(69);
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
			setState(77);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				cmdLeitura();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				cmdEscrita();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(72);
				cmdAtr();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(73);
				cmdIf();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(74);
				cmdEnquanto();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(75);
				cmdPara();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(76);
				cmdUnario();
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
			setState(79);
			match(T__4);
			setState(80);
			match(AP);
			setState(81);
			match(ID);
			 
			                        currentID = _input.LT(-1).getText();
			                        verifySymbolDeclaration(currentID);
			                    
			setState(83);
			match(FP);
			setState(84);
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
			setState(87);
			match(T__5);
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
			setState(95);
			match(ID);

			                    currentID = _input.LT(-1).getText();
			                    assigningVariableID = currentID;
			                    verifySymbolDeclaration(currentID);
			                    expressionTypes = new ArrayList<>();
			                    mathOperators = new ArrayList<>();
			                
			setState(97);
			match(ATR);
			 content = ""; 
			setState(99);
			expr();

			                    setExpressionType();
			                    verifyAssignmentType();
			                    verifyOperationValidity();
			                
			setState(101);
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
			                
			setState(105);
			match(T__6);
			setState(106);
			match(AP);
			setState(107);
			conditional();
			setState(108);
			match(FP);
			setState(109);
			match(T__7);
			setState(110);
			match(AC);
			 
			                        currentThread = new ArrayList<>();
			                        stack.push(currentThread);
			                    
			setState(113); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(112);
				cmd();
				}
				}
				setState(115); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__10) | (1L << T__11) | (1L << ID) | (1L << FIM) | (1L << UNARY))) != 0) );
			setState(117);
			match(FC);

			                        trueList = stack.pop();
			                    
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(119);
				match(T__8);
				setState(120);
				match(AP);
				setState(121);
				conditional();
				setState(122);
				match(FP);
				setState(123);
				match(AC);
				setState(125); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(124);
					cmd();
					}
					}
					setState(127); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__10) | (1L << T__11) | (1L << ID) | (1L << FIM) | (1L << UNARY))) != 0) );
				setState(129);
				match(FC);
				}
				}
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(136);
				match(T__9);
				setState(137);
				match(AC);

				                        currentThread = new ArrayList<>();
				                        stack.push(currentThread);
				                    
				setState(140); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(139);
					cmd();
					}
					}
					setState(142); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__10) | (1L << T__11) | (1L << ID) | (1L << FIM) | (1L << UNARY))) != 0) );
				setState(144);
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
			                
			setState(150);
			match(T__10);
			setState(151);
			match(AP);
			setState(152);
			conditional();
			setState(153);
			match(FP);
			setState(154);
			match(AC);

			                        currentThread = new ArrayList<>();
			                        stack.push(currentThread);
			                    
			setState(157); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(156);
				cmd();
				}
				}
				setState(159); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__10) | (1L << T__11) | (1L << ID) | (1L << FIM) | (1L << UNARY))) != 0) );
			setState(161);
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
			setState(164);
			match(T__11);
			setState(165);
			match(AP);
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				{
				setState(166);
				cmdAtr();
				}
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==VIR) {
					{
					{
					setState(167);
					match(VIR);
					setState(168);
					cmdAtr();
					}
					}
					setState(173);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(179);
			match(SEMICOLON);
			setState(180);
			conditional();
			setState(181);
			match(SEMICOLON);
			setState(192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				{
				setState(182);
				cmdAtr();
				}
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==VIR) {
					{
					{
					setState(183);
					match(VIR);
					setState(184);
					cmdAtr();
					}
					}
					setState(189);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(194);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(195);
			match(FP);
			setState(196);
			match(AC);
			setState(198); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(197);
				cmd();
				}
				}
				setState(200); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__10) | (1L << T__11) | (1L << ID) | (1L << FIM) | (1L << UNARY))) != 0) );
			setState(202);
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
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID || _la==UNARY) {
				{
				setState(212);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(204);
					match(ID);
					 
					                            currentID = _input.LT(-1).getText();
					                            verifySymbolDeclaration(currentID);
					                            verifyType(currentID, IsiType.NUMBER);                            
					                        
					setState(206);
					match(UNARY);

					                            content = _input.LT(-1).getText(); 
					                            isPostUnary = true;
					}
					break;
				case UNARY:
					{
					setState(208);
					match(UNARY);

					                            content = _input.LT(-1).getText();
					                        
					setState(210);
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
				setState(216);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(217);
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

	public static class ConditionalContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
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
		enterRule(_localctx, 26, RULE_conditional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << NUM) | (1L << TEXT))) != 0)) {
				{
				{
				{
				setState(220);
				expr();
				setState(221);
				match(OPREL);
				content += _input.LT(-1).getText();
				setState(223);
				expr();
				}
				setState(234);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LOP) {
					{
					{
					setState(225);
					match(LOP);
					content += _input.LT(-1).getText();
					setState(227);
					expr();
					setState(228);
					match(OPREL);
					content += _input.LT(-1).getText();
					setState(230);
					expr();
					}
					}
					setState(236);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(241);
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
		enterRule(_localctx, 28, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			termo();
			setState(248);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(243);
				match(OP);

				                        content += _input.LT(-1).getText();
				                        mathOperators.add(_input.LT(-1).getText());
				                    
				setState(245);
				termo();
				}
				}
				setState(250);
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
		enterRule(_localctx, 30, RULE_termo);
		try {
			setState(257);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(251);
				match(NUM);
				 
				                    content += _input.LT(-1).getText(); 
				                    expressionTypes.add(IsiType.NUMBER);
				                
				}
				break;
			case TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(253);
				match(TEXT);
				 
				                    content += _input.LT(-1).getText();
				                    expressionTypes.add(IsiType.TEXT);
				                
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(255);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\36\u0106\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\3\6\3+\n\3\r\3\16\3,\3\4\3\4\3\4\3\4\3\4\3\4\7"+
		"\4\65\n\4\f\4\16\48\13\4\3\4\3\4\3\5\3\5\3\5\3\5\5\5@\n\5\3\6\3\6\7\6"+
		"D\n\6\f\6\16\6G\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7P\n\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\6\13t"+
		"\n\13\r\13\16\13u\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\6\13\u0080\n"+
		"\13\r\13\16\13\u0081\3\13\3\13\7\13\u0086\n\13\f\13\16\13\u0089\13\13"+
		"\3\13\3\13\3\13\3\13\6\13\u008f\n\13\r\13\16\13\u0090\3\13\3\13\3\13\5"+
		"\13\u0096\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\6\f\u00a0\n\f\r\f\16\f"+
		"\u00a1\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\7\r\u00ac\n\r\f\r\16\r\u00af\13"+
		"\r\7\r\u00b1\n\r\f\r\16\r\u00b4\13\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00bc"+
		"\n\r\f\r\16\r\u00bf\13\r\7\r\u00c1\n\r\f\r\16\r\u00c4\13\r\3\r\3\r\3\r"+
		"\6\r\u00c9\n\r\r\r\16\r\u00ca\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\7\16\u00d7\n\16\f\16\16\16\u00da\13\16\3\16\3\16\3\16\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u00eb\n\17"+
		"\f\17\16\17\u00ee\13\17\7\17\u00f0\n\17\f\17\16\17\u00f3\13\17\3\20\3"+
		"\20\3\20\3\20\7\20\u00f9\n\20\f\20\16\20\u00fc\13\20\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\5\21\u0104\n\21\3\21\2\2\22\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \2\2\2\u0111\2\"\3\2\2\2\4*\3\2\2\2\6.\3\2\2\2\b?\3\2\2\2\n"+
		"A\3\2\2\2\fO\3\2\2\2\16Q\3\2\2\2\20Y\3\2\2\2\22a\3\2\2\2\24j\3\2\2\2\26"+
		"\u0097\3\2\2\2\30\u00a6\3\2\2\2\32\u00d8\3\2\2\2\34\u00f1\3\2\2\2\36\u00f4"+
		"\3\2\2\2 \u0103\3\2\2\2\"#\7\3\2\2#$\5\4\3\2$%\5\n\6\2%&\7\4\2\2&\'\7"+
		"\33\2\2\'(\b\2\1\2(\3\3\2\2\2)+\5\6\4\2*)\3\2\2\2+,\3\2\2\2,*\3\2\2\2"+
		",-\3\2\2\2-\5\3\2\2\2./\5\b\5\2/\60\7\17\2\2\60\66\b\4\1\2\61\62\7\34"+
		"\2\2\62\63\7\17\2\2\63\65\b\4\1\2\64\61\3\2\2\2\658\3\2\2\2\66\64\3\2"+
		"\2\2\66\67\3\2\2\2\679\3\2\2\28\66\3\2\2\29:\7\33\2\2:\7\3\2\2\2;<\7\5"+
		"\2\2<@\b\5\1\2=>\7\6\2\2>@\b\5\1\2?;\3\2\2\2?=\3\2\2\2@\t\3\2\2\2AE\b"+
		"\6\1\2BD\5\f\7\2CB\3\2\2\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2F\13\3\2\2\2G"+
		"E\3\2\2\2HP\5\16\b\2IP\5\20\t\2JP\5\22\n\2KP\5\24\13\2LP\5\26\f\2MP\5"+
		"\30\r\2NP\5\32\16\2OH\3\2\2\2OI\3\2\2\2OJ\3\2\2\2OK\3\2\2\2OL\3\2\2\2"+
		"OM\3\2\2\2ON\3\2\2\2P\r\3\2\2\2QR\7\7\2\2RS\7\20\2\2ST\7\17\2\2TU\b\b"+
		"\1\2UV\7\21\2\2VW\7\33\2\2WX\b\b\1\2X\17\3\2\2\2YZ\7\b\2\2Z[\7\20\2\2"+
		"[\\\7\17\2\2\\]\b\t\1\2]^\7\21\2\2^_\7\33\2\2_`\b\t\1\2`\21\3\2\2\2ab"+
		"\7\17\2\2bc\b\n\1\2cd\7\22\2\2de\b\n\1\2ef\5\36\20\2fg\b\n\1\2gh\7\33"+
		"\2\2hi\b\n\1\2i\23\3\2\2\2jk\b\13\1\2kl\7\t\2\2lm\7\20\2\2mn\5\34\17\2"+
		"no\7\21\2\2op\7\n\2\2pq\7\30\2\2qs\b\13\1\2rt\5\f\7\2sr\3\2\2\2tu\3\2"+
		"\2\2us\3\2\2\2uv\3\2\2\2vw\3\2\2\2wx\7\31\2\2x\u0087\b\13\1\2yz\7\13\2"+
		"\2z{\7\20\2\2{|\5\34\17\2|}\7\21\2\2}\177\7\30\2\2~\u0080\5\f\7\2\177"+
		"~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082"+
		"\u0083\3\2\2\2\u0083\u0084\7\31\2\2\u0084\u0086\3\2\2\2\u0085y\3\2\2\2"+
		"\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0095"+
		"\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008b\7\f\2\2\u008b\u008c\7\30\2\2"+
		"\u008c\u008e\b\13\1\2\u008d\u008f\5\f\7\2\u008e\u008d\3\2\2\2\u008f\u0090"+
		"\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\3\2\2\2\u0092"+
		"\u0093\7\31\2\2\u0093\u0094\b\13\1\2\u0094\u0096\3\2\2\2\u0095\u008a\3"+
		"\2\2\2\u0095\u0096\3\2\2\2\u0096\25\3\2\2\2\u0097\u0098\b\f\1\2\u0098"+
		"\u0099\7\r\2\2\u0099\u009a\7\20\2\2\u009a\u009b\5\34\17\2\u009b\u009c"+
		"\7\21\2\2\u009c\u009d\7\30\2\2\u009d\u009f\b\f\1\2\u009e\u00a0\5\f\7\2"+
		"\u009f\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2"+
		"\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\7\31\2\2\u00a4\u00a5\b\f\1\2"+
		"\u00a5\27\3\2\2\2\u00a6\u00a7\7\16\2\2\u00a7\u00b2\7\20\2\2\u00a8\u00ad"+
		"\5\22\n\2\u00a9\u00aa\7\34\2\2\u00aa\u00ac\5\22\n\2\u00ab\u00a9\3\2\2"+
		"\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b1"+
		"\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00a8\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2"+
		"\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b5\3\2\2\2\u00b4\u00b2\3\2"+
		"\2\2\u00b5\u00b6\7\35\2\2\u00b6\u00b7\5\34\17\2\u00b7\u00c2\7\35\2\2\u00b8"+
		"\u00bd\5\22\n\2\u00b9\u00ba\7\34\2\2\u00ba\u00bc\5\22\n\2\u00bb\u00b9"+
		"\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be"+
		"\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00b8\3\2\2\2\u00c1\u00c4\3\2"+
		"\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c5\3\2\2\2\u00c4"+
		"\u00c2\3\2\2\2\u00c5\u00c6\7\21\2\2\u00c6\u00c8\7\30\2\2\u00c7\u00c9\5"+
		"\f\7\2\u00c8\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca"+
		"\u00cb\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\7\31\2\2\u00cd\31\3\2\2"+
		"\2\u00ce\u00cf\7\17\2\2\u00cf\u00d0\b\16\1\2\u00d0\u00d1\7\36\2\2\u00d1"+
		"\u00d7\b\16\1\2\u00d2\u00d3\7\36\2\2\u00d3\u00d4\b\16\1\2\u00d4\u00d5"+
		"\7\17\2\2\u00d5\u00d7\b\16\1\2\u00d6\u00ce\3\2\2\2\u00d6\u00d2\3\2\2\2"+
		"\u00d7\u00da\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00db"+
		"\3\2\2\2\u00da\u00d8\3\2\2\2\u00db\u00dc\7\33\2\2\u00dc\u00dd\b\16\1\2"+
		"\u00dd\33\3\2\2\2\u00de\u00df\5\36\20\2\u00df\u00e0\7\26\2\2\u00e0\u00e1"+
		"\b\17\1\2\u00e1\u00e2\5\36\20\2\u00e2\u00ec\3\2\2\2\u00e3\u00e4\7\27\2"+
		"\2\u00e4\u00e5\b\17\1\2\u00e5\u00e6\5\36\20\2\u00e6\u00e7\7\26\2\2\u00e7"+
		"\u00e8\b\17\1\2\u00e8\u00e9\5\36\20\2\u00e9\u00eb\3\2\2\2\u00ea\u00e3"+
		"\3\2\2\2\u00eb\u00ee\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed"+
		"\u00f0\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef\u00de\3\2\2\2\u00f0\u00f3\3\2"+
		"\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\35\3\2\2\2\u00f3\u00f1"+
		"\3\2\2\2\u00f4\u00fa\5 \21\2\u00f5\u00f6\7\23\2\2\u00f6\u00f7\b\20\1\2"+
		"\u00f7\u00f9\5 \21\2\u00f8\u00f5\3\2\2\2\u00f9\u00fc\3\2\2\2\u00fa\u00f8"+
		"\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\37\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fd"+
		"\u00fe\7\24\2\2\u00fe\u0104\b\21\1\2\u00ff\u0100\7\25\2\2\u0100\u0104"+
		"\b\21\1\2\u0101\u0102\7\17\2\2\u0102\u0104\b\21\1\2\u0103\u00fd\3\2\2"+
		"\2\u0103\u00ff\3\2\2\2\u0103\u0101\3\2\2\2\u0104!\3\2\2\2\30,\66?EOu\u0081"+
		"\u0087\u0090\u0095\u00a1\u00ad\u00b2\u00bd\u00c2\u00ca\u00d6\u00d8\u00ec"+
		"\u00f1\u00fa\u0103";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}