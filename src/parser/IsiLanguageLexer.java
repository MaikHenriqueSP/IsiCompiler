// Generated from /media/maik/B4FA6A2DFA69EC54/Users/Windows  7/Desktop/UFABC/12° QUAD - LOADING/Compiladores - Isidro/Projeto/IsiCompiler/src/IsiLanguage.g4 by ANTLR 4.8
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IsiLanguageLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, ID=13, AP=14, FP=15, ATR=16, OP=17, NUM=18, 
		OPREL=19, AC=20, FC=21, WS=22, FIM=23;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "ID", "AP", "FP", "ATR", "OP", "NUM", "OPREL", 
			"AC", "FC", "WS", "FIM"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog'", "'declare'", "','", "'leia'", "'escreva'", 
			"'se'", "'entao'", "'senao'", "'enquanto'", "'para'", "';'", null, "'('", 
			"')'", "':='", null, null, null, "'{'", "'}'", null, "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "ID", "AP", "FP", "ATR", "OP", "NUM", "OPREL", "AC", "FC", "WS", 
			"FIM"
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


	public IsiLanguageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "IsiLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\31\u00aa\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3"+
		"\f\3\r\3\r\3\16\3\16\7\16{\n\16\f\16\16\16~\13\16\3\17\3\17\3\20\3\20"+
		"\3\21\3\21\3\21\3\22\3\22\3\23\6\23\u008a\n\23\r\23\16\23\u008b\3\23\3"+
		"\23\6\23\u0090\n\23\r\23\16\23\u0091\5\23\u0094\n\23\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\5\24\u009f\n\24\3\25\3\25\3\26\3\26\3\27"+
		"\3\27\3\27\3\27\3\30\3\30\2\2\31\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\3\2\b\3\2c|\5\2\62;C\\c|\5\2,-//\61\61\3\2\62;\4\2>>@@\5\2\13\f\17\17"+
		"\"\"\2\u00b1\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
		"\2\2/\3\2\2\2\3\61\3\2\2\2\5:\3\2\2\2\7B\3\2\2\2\tJ\3\2\2\2\13L\3\2\2"+
		"\2\rQ\3\2\2\2\17Y\3\2\2\2\21\\\3\2\2\2\23b\3\2\2\2\25h\3\2\2\2\27q\3\2"+
		"\2\2\31v\3\2\2\2\33x\3\2\2\2\35\177\3\2\2\2\37\u0081\3\2\2\2!\u0083\3"+
		"\2\2\2#\u0086\3\2\2\2%\u0089\3\2\2\2\'\u009e\3\2\2\2)\u00a0\3\2\2\2+\u00a2"+
		"\3\2\2\2-\u00a4\3\2\2\2/\u00a8\3\2\2\2\61\62\7r\2\2\62\63\7t\2\2\63\64"+
		"\7q\2\2\64\65\7i\2\2\65\66\7t\2\2\66\67\7c\2\2\678\7o\2\289\7c\2\29\4"+
		"\3\2\2\2:;\7h\2\2;<\7k\2\2<=\7o\2\2=>\7r\2\2>?\7t\2\2?@\7q\2\2@A\7i\2"+
		"\2A\6\3\2\2\2BC\7f\2\2CD\7g\2\2DE\7e\2\2EF\7n\2\2FG\7c\2\2GH\7t\2\2HI"+
		"\7g\2\2I\b\3\2\2\2JK\7.\2\2K\n\3\2\2\2LM\7n\2\2MN\7g\2\2NO\7k\2\2OP\7"+
		"c\2\2P\f\3\2\2\2QR\7g\2\2RS\7u\2\2ST\7e\2\2TU\7t\2\2UV\7g\2\2VW\7x\2\2"+
		"WX\7c\2\2X\16\3\2\2\2YZ\7u\2\2Z[\7g\2\2[\20\3\2\2\2\\]\7g\2\2]^\7p\2\2"+
		"^_\7v\2\2_`\7c\2\2`a\7q\2\2a\22\3\2\2\2bc\7u\2\2cd\7g\2\2de\7p\2\2ef\7"+
		"c\2\2fg\7q\2\2g\24\3\2\2\2hi\7g\2\2ij\7p\2\2jk\7s\2\2kl\7w\2\2lm\7c\2"+
		"\2mn\7p\2\2no\7v\2\2op\7q\2\2p\26\3\2\2\2qr\7r\2\2rs\7c\2\2st\7t\2\2t"+
		"u\7c\2\2u\30\3\2\2\2vw\7=\2\2w\32\3\2\2\2x|\t\2\2\2y{\t\3\2\2zy\3\2\2"+
		"\2{~\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\34\3\2\2\2~|\3\2\2\2\177\u0080\7*\2"+
		"\2\u0080\36\3\2\2\2\u0081\u0082\7+\2\2\u0082 \3\2\2\2\u0083\u0084\7<\2"+
		"\2\u0084\u0085\7?\2\2\u0085\"\3\2\2\2\u0086\u0087\t\4\2\2\u0087$\3\2\2"+
		"\2\u0088\u008a\t\5\2\2\u0089\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u0089"+
		"\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u0093\3\2\2\2\u008d\u008f\7\60\2\2"+
		"\u008e\u0090\t\5\2\2\u008f\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u008f"+
		"\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0094\3\2\2\2\u0093\u008d\3\2\2\2\u0093"+
		"\u0094\3\2\2\2\u0094&\3\2\2\2\u0095\u009f\t\6\2\2\u0096\u0097\7>\2\2\u0097"+
		"\u009f\7?\2\2\u0098\u0099\7@\2\2\u0099\u009f\7?\2\2\u009a\u009b\7#\2\2"+
		"\u009b\u009f\7?\2\2\u009c\u009d\7?\2\2\u009d\u009f\7?\2\2\u009e\u0095"+
		"\3\2\2\2\u009e\u0096\3\2\2\2\u009e\u0098\3\2\2\2\u009e\u009a\3\2\2\2\u009e"+
		"\u009c\3\2\2\2\u009f(\3\2\2\2\u00a0\u00a1\7}\2\2\u00a1*\3\2\2\2\u00a2"+
		"\u00a3\7\177\2\2\u00a3,\3\2\2\2\u00a4\u00a5\t\7\2\2\u00a5\u00a6\3\2\2"+
		"\2\u00a6\u00a7\b\27\2\2\u00a7.\3\2\2\2\u00a8\u00a9\7\60\2\2\u00a9\60\3"+
		"\2\2\2\t\2z|\u008b\u0091\u0093\u009e\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}