// Generated from /media/maik/B4FA6A2DFA69EC54/Users/Windows  7/Desktop/UFABC/12° QUAD - LOADING/Compiladores - Isidro/Projeto/IsiCompiler/src/IsiLanguage.g4 by ANTLR 4.8
package parser;

    import datastructures.*;
    import exceptions.*;
    import ast.*;
    import util.*;
    import java.util.*;

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
		OPREL=19, LOP=20, AC=21, FC=22, WS=23, FIM=24, VIR=25, SEMICOLON=26;
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
			"LOP", "AC", "FC", "WS", "FIM", "VIR", "SEMICOLON"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog'", "'numero'", "'texto'", "'leia'", "'escreva'", 
			"'se'", "'entao'", "'senao se'", "'senao'", "'enquanto'", "'para'", null, 
			"'('", "')'", "':='", null, null, null, null, "'{'", "'}'", null, "'.'", 
			"','", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "ID", "AP", "FP", "ATR", "OP", "NUM", "OPREL", "LOP", "AC", "FC", 
			"WS", "FIM", "VIR", "SEMICOLON"
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

	    public void generateProgram() {
	        program.generateProgram();
	    }

	    public void showCommands() {
	        for (AbstractCommand c : program.getCommands()) {
	            System.out.println(c);
	        }
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\34\u00c4\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3"+
		"\r\3\r\3\16\3\16\7\16\u008b\n\16\f\16\16\16\u008e\13\16\3\17\3\17\3\20"+
		"\3\20\3\21\3\21\3\21\3\22\3\22\3\23\6\23\u009a\n\23\r\23\16\23\u009b\3"+
		"\23\3\23\6\23\u00a0\n\23\r\23\16\23\u00a1\5\23\u00a4\n\23\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00af\n\24\3\25\3\25\3\25\3\25"+
		"\5\25\u00b5\n\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3\32"+
		"\3\32\3\33\3\33\2\2\34\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\3\2\b\3\2c|\5\2\62;C\\c|\5\2,-//\61\61\3\2\62;\4\2>>@@\5\2\13\f"+
		"\17\17\"\"\2\u00cc\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\3\67\3\2\2\2"+
		"\5@\3\2\2\2\7H\3\2\2\2\tO\3\2\2\2\13U\3\2\2\2\rZ\3\2\2\2\17b\3\2\2\2\21"+
		"e\3\2\2\2\23k\3\2\2\2\25t\3\2\2\2\27z\3\2\2\2\31\u0083\3\2\2\2\33\u0088"+
		"\3\2\2\2\35\u008f\3\2\2\2\37\u0091\3\2\2\2!\u0093\3\2\2\2#\u0096\3\2\2"+
		"\2%\u0099\3\2\2\2\'\u00ae\3\2\2\2)\u00b4\3\2\2\2+\u00b6\3\2\2\2-\u00b8"+
		"\3\2\2\2/\u00ba\3\2\2\2\61\u00be\3\2\2\2\63\u00c0\3\2\2\2\65\u00c2\3\2"+
		"\2\2\678\7r\2\289\7t\2\29:\7q\2\2:;\7i\2\2;<\7t\2\2<=\7c\2\2=>\7o\2\2"+
		">?\7c\2\2?\4\3\2\2\2@A\7h\2\2AB\7k\2\2BC\7o\2\2CD\7r\2\2DE\7t\2\2EF\7"+
		"q\2\2FG\7i\2\2G\6\3\2\2\2HI\7p\2\2IJ\7w\2\2JK\7o\2\2KL\7g\2\2LM\7t\2\2"+
		"MN\7q\2\2N\b\3\2\2\2OP\7v\2\2PQ\7g\2\2QR\7z\2\2RS\7v\2\2ST\7q\2\2T\n\3"+
		"\2\2\2UV\7n\2\2VW\7g\2\2WX\7k\2\2XY\7c\2\2Y\f\3\2\2\2Z[\7g\2\2[\\\7u\2"+
		"\2\\]\7e\2\2]^\7t\2\2^_\7g\2\2_`\7x\2\2`a\7c\2\2a\16\3\2\2\2bc\7u\2\2"+
		"cd\7g\2\2d\20\3\2\2\2ef\7g\2\2fg\7p\2\2gh\7v\2\2hi\7c\2\2ij\7q\2\2j\22"+
		"\3\2\2\2kl\7u\2\2lm\7g\2\2mn\7p\2\2no\7c\2\2op\7q\2\2pq\7\"\2\2qr\7u\2"+
		"\2rs\7g\2\2s\24\3\2\2\2tu\7u\2\2uv\7g\2\2vw\7p\2\2wx\7c\2\2xy\7q\2\2y"+
		"\26\3\2\2\2z{\7g\2\2{|\7p\2\2|}\7s\2\2}~\7w\2\2~\177\7c\2\2\177\u0080"+
		"\7p\2\2\u0080\u0081\7v\2\2\u0081\u0082\7q\2\2\u0082\30\3\2\2\2\u0083\u0084"+
		"\7r\2\2\u0084\u0085\7c\2\2\u0085\u0086\7t\2\2\u0086\u0087\7c\2\2\u0087"+
		"\32\3\2\2\2\u0088\u008c\t\2\2\2\u0089\u008b\t\3\2\2\u008a\u0089\3\2\2"+
		"\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\34"+
		"\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0090\7*\2\2\u0090\36\3\2\2\2\u0091"+
		"\u0092\7+\2\2\u0092 \3\2\2\2\u0093\u0094\7<\2\2\u0094\u0095\7?\2\2\u0095"+
		"\"\3\2\2\2\u0096\u0097\t\4\2\2\u0097$\3\2\2\2\u0098\u009a\t\5\2\2\u0099"+
		"\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2"+
		"\2\2\u009c\u00a3\3\2\2\2\u009d\u009f\7\60\2\2\u009e\u00a0\t\5\2\2\u009f"+
		"\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2"+
		"\2\2\u00a2\u00a4\3\2\2\2\u00a3\u009d\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4"+
		"&\3\2\2\2\u00a5\u00af\t\6\2\2\u00a6\u00a7\7>\2\2\u00a7\u00af\7?\2\2\u00a8"+
		"\u00a9\7@\2\2\u00a9\u00af\7?\2\2\u00aa\u00ab\7#\2\2\u00ab\u00af\7?\2\2"+
		"\u00ac\u00ad\7?\2\2\u00ad\u00af\7?\2\2\u00ae\u00a5\3\2\2\2\u00ae\u00a6"+
		"\3\2\2\2\u00ae\u00a8\3\2\2\2\u00ae\u00aa\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af"+
		"(\3\2\2\2\u00b0\u00b1\7(\2\2\u00b1\u00b5\7(\2\2\u00b2\u00b3\7~\2\2\u00b3"+
		"\u00b5\7~\2\2\u00b4\u00b0\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5*\3\2\2\2\u00b6"+
		"\u00b7\7}\2\2\u00b7,\3\2\2\2\u00b8\u00b9\7\177\2\2\u00b9.\3\2\2\2\u00ba"+
		"\u00bb\t\7\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00bd\b\30\2\2\u00bd\60\3\2\2"+
		"\2\u00be\u00bf\7\60\2\2\u00bf\62\3\2\2\2\u00c0\u00c1\7.\2\2\u00c1\64\3"+
		"\2\2\2\u00c2\u00c3\7=\2\2\u00c3\66\3\2\2\2\n\2\u008a\u008c\u009b\u00a1"+
		"\u00a3\u00ae\u00b4\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}