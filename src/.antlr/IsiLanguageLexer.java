// Generated from c:\Users\Windows  7\Desktop\UFABC\12° QUAD - LOADING\Compiladores - Isidro\Projeto\IsiCompiler\src\IsiLanguage.g4 by ANTLR 4.8
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
		ID=10, AP=11, FP=12, ATR=13, OP=14, NUM=15, OPREL=16, AC=17, FC=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"ID", "AP", "FP", "ATR", "OP", "NUM", "OPREL", "AC", "FC"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'declare'", "','", "'.'", "'leia'", "'escreva'", 
			"'se'", "'entao'", "'senao'", null, "'('", "')'", "':='", null, null, 
			null, "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "ID", "AP", 
			"FP", "ATR", "OP", "NUM", "OPREL", "AC", "FC"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24|\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\7\13[\n\13\f\13\16\13^\13\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17"+
		"\3\17\3\20\6\20j\n\20\r\20\16\20k\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\5\21w\n\21\3\22\3\22\3\23\3\23\2\2\24\3\3\5\4\7\5\t\6\13\7\r"+
		"\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\3\2\7"+
		"\3\2c|\5\2\62;C\\c|\5\2,-//\61\61\3\2\62;\4\2>>@@\2\u0081\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\3\'\3\2\2\2\5\60\3\2\2\2\78\3\2\2\2\t:\3\2\2\2\13<\3\2\2\2\rA\3\2\2"+
		"\2\17I\3\2\2\2\21L\3\2\2\2\23R\3\2\2\2\25X\3\2\2\2\27_\3\2\2\2\31a\3\2"+
		"\2\2\33c\3\2\2\2\35f\3\2\2\2\37i\3\2\2\2!v\3\2\2\2#x\3\2\2\2%z\3\2\2\2"+
		"\'(\7r\2\2()\7t\2\2)*\7q\2\2*+\7i\2\2+,\7t\2\2,-\7c\2\2-.\7o\2\2./\7c"+
		"\2\2/\4\3\2\2\2\60\61\7f\2\2\61\62\7g\2\2\62\63\7e\2\2\63\64\7n\2\2\64"+
		"\65\7c\2\2\65\66\7t\2\2\66\67\7g\2\2\67\6\3\2\2\289\7.\2\29\b\3\2\2\2"+
		":;\7\60\2\2;\n\3\2\2\2<=\7n\2\2=>\7g\2\2>?\7k\2\2?@\7c\2\2@\f\3\2\2\2"+
		"AB\7g\2\2BC\7u\2\2CD\7e\2\2DE\7t\2\2EF\7g\2\2FG\7x\2\2GH\7c\2\2H\16\3"+
		"\2\2\2IJ\7u\2\2JK\7g\2\2K\20\3\2\2\2LM\7g\2\2MN\7p\2\2NO\7v\2\2OP\7c\2"+
		"\2PQ\7q\2\2Q\22\3\2\2\2RS\7u\2\2ST\7g\2\2TU\7p\2\2UV\7c\2\2VW\7q\2\2W"+
		"\24\3\2\2\2X\\\t\2\2\2Y[\t\3\2\2ZY\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2"+
		"\2\2]\26\3\2\2\2^\\\3\2\2\2_`\7*\2\2`\30\3\2\2\2ab\7+\2\2b\32\3\2\2\2"+
		"cd\7<\2\2de\7?\2\2e\34\3\2\2\2fg\t\4\2\2g\36\3\2\2\2hj\t\5\2\2ih\3\2\2"+
		"\2jk\3\2\2\2ki\3\2\2\2kl\3\2\2\2l \3\2\2\2mw\t\6\2\2no\7>\2\2ow\7?\2\2"+
		"pq\7@\2\2qw\7?\2\2rs\7#\2\2sw\7?\2\2tu\7?\2\2uw\7?\2\2vm\3\2\2\2vn\3\2"+
		"\2\2vp\3\2\2\2vr\3\2\2\2vt\3\2\2\2w\"\3\2\2\2xy\7}\2\2y$\3\2\2\2z{\7\177"+
		"\2\2{&\3\2\2\2\7\2Z\\kv\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}