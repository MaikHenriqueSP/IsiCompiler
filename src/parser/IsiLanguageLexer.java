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
		T__9=10, T__10=11, TIPO=12, ID=13, AP=14, FP=15, ATR=16, OP=17, NUM=18, 
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
			"T__9", "T__10", "TIPO", "ID", "AP", "FP", "ATR", "OP", "NUM", "OPREL", 
			"AC", "FC", "WS", "FIM"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog'", "','", "'leia'", "'escreva'", "'se'", 
			"'entao'", "'senao'", "'enquanto'", "'para'", "';'", null, null, "'('", 
			"')'", "':='", null, null, null, "'{'", "'}'", null, "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"TIPO", "ID", "AP", "FP", "ATR", "OP", "NUM", "OPREL", "AC", "FC", "WS", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\31\u00af\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3"+
		"\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\5\r|\n\r\3\16\3\16\7\16\u0080\n\16\f\16\16\16\u0083"+
		"\13\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\6\23\u008f\n"+
		"\23\r\23\16\23\u0090\3\23\3\23\6\23\u0095\n\23\r\23\16\23\u0096\5\23\u0099"+
		"\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00a4\n\24\3\25"+
		"\3\25\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\2\2\31\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30/\31\3\2\b\3\2c|\5\2\62;C\\c|\5\2,-//\61\61\3\2\62;\4\2"+
		">>@@\5\2\13\f\17\17\"\"\2\u00b7\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\3\61\3\2\2\2\5:\3\2\2\2\7B\3\2\2\2\t"+
		"D\3\2\2\2\13I\3\2\2\2\rQ\3\2\2\2\17T\3\2\2\2\21Z\3\2\2\2\23`\3\2\2\2\25"+
		"i\3\2\2\2\27n\3\2\2\2\31{\3\2\2\2\33}\3\2\2\2\35\u0084\3\2\2\2\37\u0086"+
		"\3\2\2\2!\u0088\3\2\2\2#\u008b\3\2\2\2%\u008e\3\2\2\2\'\u00a3\3\2\2\2"+
		")\u00a5\3\2\2\2+\u00a7\3\2\2\2-\u00a9\3\2\2\2/\u00ad\3\2\2\2\61\62\7r"+
		"\2\2\62\63\7t\2\2\63\64\7q\2\2\64\65\7i\2\2\65\66\7t\2\2\66\67\7c\2\2"+
		"\678\7o\2\289\7c\2\29\4\3\2\2\2:;\7h\2\2;<\7k\2\2<=\7o\2\2=>\7r\2\2>?"+
		"\7t\2\2?@\7q\2\2@A\7i\2\2A\6\3\2\2\2BC\7.\2\2C\b\3\2\2\2DE\7n\2\2EF\7"+
		"g\2\2FG\7k\2\2GH\7c\2\2H\n\3\2\2\2IJ\7g\2\2JK\7u\2\2KL\7e\2\2LM\7t\2\2"+
		"MN\7g\2\2NO\7x\2\2OP\7c\2\2P\f\3\2\2\2QR\7u\2\2RS\7g\2\2S\16\3\2\2\2T"+
		"U\7g\2\2UV\7p\2\2VW\7v\2\2WX\7c\2\2XY\7q\2\2Y\20\3\2\2\2Z[\7u\2\2[\\\7"+
		"g\2\2\\]\7p\2\2]^\7c\2\2^_\7q\2\2_\22\3\2\2\2`a\7g\2\2ab\7p\2\2bc\7s\2"+
		"\2cd\7w\2\2de\7c\2\2ef\7p\2\2fg\7v\2\2gh\7q\2\2h\24\3\2\2\2ij\7r\2\2j"+
		"k\7c\2\2kl\7t\2\2lm\7c\2\2m\26\3\2\2\2no\7=\2\2o\30\3\2\2\2pq\7p\2\2q"+
		"r\7w\2\2rs\7o\2\2st\7g\2\2tu\7t\2\2u|\7q\2\2vw\7v\2\2wx\7g\2\2xy\7z\2"+
		"\2yz\7v\2\2z|\7q\2\2{p\3\2\2\2{v\3\2\2\2|\32\3\2\2\2}\u0081\t\2\2\2~\u0080"+
		"\t\3\2\2\177~\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082"+
		"\3\2\2\2\u0082\34\3\2\2\2\u0083\u0081\3\2\2\2\u0084\u0085\7*\2\2\u0085"+
		"\36\3\2\2\2\u0086\u0087\7+\2\2\u0087 \3\2\2\2\u0088\u0089\7<\2\2\u0089"+
		"\u008a\7?\2\2\u008a\"\3\2\2\2\u008b\u008c\t\4\2\2\u008c$\3\2\2\2\u008d"+
		"\u008f\t\5\2\2\u008e\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u008e\3\2"+
		"\2\2\u0090\u0091\3\2\2\2\u0091\u0098\3\2\2\2\u0092\u0094\7\60\2\2\u0093"+
		"\u0095\t\5\2\2\u0094\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0094\3\2"+
		"\2\2\u0096\u0097\3\2\2\2\u0097\u0099\3\2\2\2\u0098\u0092\3\2\2\2\u0098"+
		"\u0099\3\2\2\2\u0099&\3\2\2\2\u009a\u00a4\t\6\2\2\u009b\u009c\7>\2\2\u009c"+
		"\u00a4\7?\2\2\u009d\u009e\7@\2\2\u009e\u00a4\7?\2\2\u009f\u00a0\7#\2\2"+
		"\u00a0\u00a4\7?\2\2\u00a1\u00a2\7?\2\2\u00a2\u00a4\7?\2\2\u00a3\u009a"+
		"\3\2\2\2\u00a3\u009b\3\2\2\2\u00a3\u009d\3\2\2\2\u00a3\u009f\3\2\2\2\u00a3"+
		"\u00a1\3\2\2\2\u00a4(\3\2\2\2\u00a5\u00a6\7}\2\2\u00a6*\3\2\2\2\u00a7"+
		"\u00a8\7\177\2\2\u00a8,\3\2\2\2\u00a9\u00aa\t\7\2\2\u00aa\u00ab\3\2\2"+
		"\2\u00ab\u00ac\b\27\2\2\u00ac.\3\2\2\2\u00ad\u00ae\7\60\2\2\u00ae\60\3"+
		"\2\2\2\n\2{\177\u0081\u0090\u0096\u0098\u00a3\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}