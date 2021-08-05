// Generated from /media/maik/B4FA6A2DFA69EC54/Users/Windows  7/Desktop/UFABC/12° QUAD - LOADING/Compiladores - Isidro/Projeto/IsiCompiler/src/IsiLanguage.g4 by ANTLR 4.8
package parser;
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
		ID=10, AP=11, FP=12, ATR=13, OP=14, NUM=15, OPREL=16, AC=17, FC=18, WS=19, 
		FIM=20;
	public static final int
		RULE_programa = 0, RULE_declara = 1, RULE_bloco = 2, RULE_cmd = 3, RULE_cmdLeitura = 4, 
		RULE_cmdEscrita = 5, RULE_cmdExpr = 6, RULE_cmdIf = 7, RULE_expr = 8, 
		RULE_termo = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "declara", "bloco", "cmd", "cmdLeitura", "cmdEscrita", "cmdExpr", 
			"cmdIf", "expr", "termo"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog'", "'declare'", "','", "'leia'", "'escreva'", 
			"'se'", "'entao'", "'senao'", null, "'('", "')'", "':='", null, null, 
			null, "'{'", "'}'", null, "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "ID", "AP", 
			"FP", "ATR", "OP", "NUM", "OPREL", "AC", "FC", "WS", "FIM"
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
			setState(20);
			match(T__0);
			setState(21);
			declara();
			setState(22);
			bloco();
			setState(23);
			match(T__1);
			setState(24);
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

	public static class DeclaraContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(IsiLanguageParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLanguageParser.ID, i);
		}
		public TerminalNode FIM() { return getToken(IsiLanguageParser.FIM, 0); }
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
			setState(26);
			match(T__2);
			setState(27);
			match(ID);
			setState(32);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(28);
				match(T__3);
				setState(29);
				match(ID);
				}
				}
				setState(34);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(35);
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

	public static class BlocoContext extends ParserRuleContext {
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public List<TerminalNode> FIM() { return getTokens(IsiLanguageParser.FIM); }
		public TerminalNode FIM(int i) {
			return getToken(IsiLanguageParser.FIM, i);
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
		enterRule(_localctx, 4, RULE_bloco);
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
				setState(37);
				cmd();
				setState(38);
				match(FIM);
				}
				}
				setState(42); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << ID))) != 0) );
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
		public CmdExprContext cmdExpr() {
			return getRuleContext(CmdExprContext.class,0);
		}
		public CmdIfContext cmdIf() {
			return getRuleContext(CmdIfContext.class,0);
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
		enterRule(_localctx, 6, RULE_cmd);
		try {
			setState(48);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				cmdLeitura();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				cmdEscrita();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(46);
				cmdExpr();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 4);
				{
				setState(47);
				cmdIf();
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
		enterRule(_localctx, 8, RULE_cmdLeitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(T__4);
			setState(51);
			match(AP);
			setState(52);
			match(ID);
			setState(53);
			match(FP);
			setState(54);
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
		enterRule(_localctx, 10, RULE_cmdEscrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(T__5);
			setState(57);
			match(AP);
			setState(58);
			match(ID);
			setState(59);
			match(FP);
			setState(60);
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

	public static class CmdExprContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsiLanguageParser.ID, 0); }
		public TerminalNode ATR() { return getToken(IsiLanguageParser.ATR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FIM() { return getToken(IsiLanguageParser.FIM, 0); }
		public CmdExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).enterCmdExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLanguageListener ) ((IsiLanguageListener)listener).exitCmdExpr(this);
		}
	}

	public final CmdExprContext cmdExpr() throws RecognitionException {
		CmdExprContext _localctx = new CmdExprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(ID);
			setState(63);
			match(ATR);
			setState(64);
			expr();
			setState(65);
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

	public static class CmdIfContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLanguageParser.AP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode OPREL() { return getToken(IsiLanguageParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(IsiLanguageParser.FP, 0); }
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
		enterRule(_localctx, 14, RULE_cmdIf);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(T__6);
			setState(68);
			match(AP);
			setState(69);
			expr();
			setState(70);
			match(OPREL);
			setState(71);
			match(FP);
			setState(72);
			match(T__7);
			setState(73);
			match(AC);
			setState(75); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(74);
				cmd();
				}
				}
				setState(77); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << ID))) != 0) );
			setState(79);
			match(FC);
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(80);
				match(T__8);
				setState(81);
				match(AC);
				setState(83); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(82);
					cmd();
					}
					}
					setState(85); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << ID))) != 0) );
				setState(87);
				match(FC);
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
		enterRule(_localctx, 16, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			termo();
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(92);
				match(OP);
				setState(93);
				termo();
				}
				}
				setState(98);
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
		enterRule(_localctx, 18, RULE_termo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==NUM) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\26h\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3!\n\3\f\3\16\3$\13\3\3\3\3\3"+
		"\3\4\3\4\3\4\6\4+\n\4\r\4\16\4,\3\5\3\5\3\5\3\5\5\5\63\n\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\6\tN\n\t\r\t\16\tO\3\t\3\t\3\t\3\t\6\tV\n\t\r\t\16"+
		"\tW\3\t\3\t\5\t\\\n\t\3\n\3\n\3\n\7\na\n\n\f\n\16\nd\13\n\3\13\3\13\3"+
		"\13\2\2\f\2\4\6\b\n\f\16\20\22\24\2\3\4\2\f\f\21\21\2f\2\26\3\2\2\2\4"+
		"\34\3\2\2\2\6*\3\2\2\2\b\62\3\2\2\2\n\64\3\2\2\2\f:\3\2\2\2\16@\3\2\2"+
		"\2\20E\3\2\2\2\22]\3\2\2\2\24e\3\2\2\2\26\27\7\3\2\2\27\30\5\4\3\2\30"+
		"\31\5\6\4\2\31\32\7\4\2\2\32\33\7\26\2\2\33\3\3\2\2\2\34\35\7\5\2\2\35"+
		"\"\7\f\2\2\36\37\7\6\2\2\37!\7\f\2\2 \36\3\2\2\2!$\3\2\2\2\" \3\2\2\2"+
		"\"#\3\2\2\2#%\3\2\2\2$\"\3\2\2\2%&\7\26\2\2&\5\3\2\2\2\'(\5\b\5\2()\7"+
		"\26\2\2)+\3\2\2\2*\'\3\2\2\2+,\3\2\2\2,*\3\2\2\2,-\3\2\2\2-\7\3\2\2\2"+
		".\63\5\n\6\2/\63\5\f\7\2\60\63\5\16\b\2\61\63\5\20\t\2\62.\3\2\2\2\62"+
		"/\3\2\2\2\62\60\3\2\2\2\62\61\3\2\2\2\63\t\3\2\2\2\64\65\7\7\2\2\65\66"+
		"\7\r\2\2\66\67\7\f\2\2\678\7\16\2\289\7\26\2\29\13\3\2\2\2:;\7\b\2\2;"+
		"<\7\r\2\2<=\7\f\2\2=>\7\16\2\2>?\7\26\2\2?\r\3\2\2\2@A\7\f\2\2AB\7\17"+
		"\2\2BC\5\22\n\2CD\7\26\2\2D\17\3\2\2\2EF\7\t\2\2FG\7\r\2\2GH\5\22\n\2"+
		"HI\7\22\2\2IJ\7\16\2\2JK\7\n\2\2KM\7\23\2\2LN\5\b\5\2ML\3\2\2\2NO\3\2"+
		"\2\2OM\3\2\2\2OP\3\2\2\2PQ\3\2\2\2Q[\7\24\2\2RS\7\13\2\2SU\7\23\2\2TV"+
		"\5\b\5\2UT\3\2\2\2VW\3\2\2\2WU\3\2\2\2WX\3\2\2\2XY\3\2\2\2YZ\7\24\2\2"+
		"Z\\\3\2\2\2[R\3\2\2\2[\\\3\2\2\2\\\21\3\2\2\2]b\5\24\13\2^_\7\20\2\2_"+
		"a\5\24\13\2`^\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2c\23\3\2\2\2db\3\2"+
		"\2\2ef\t\2\2\2f\25\3\2\2\2\t\",\62OW[b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}