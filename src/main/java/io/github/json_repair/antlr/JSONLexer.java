// Generated from src/main/resources/JSON.g4 by ANTLR 4.13.1
package io.github.json_repair.antlr;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class JSONLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BEGIN_ARRAY=1, BEGIN_OBJECT=2, END_OBJECT=3, END_ARRAY=4, VALUE_SEPARATOR=5, 
		NAME_SEPARATOR=6, FALSE=7, TRUE=8, NULL=9, STRING=10, NUMBER=11, WS=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"BEGIN_ARRAY", "BEGIN_OBJECT", "END_OBJECT", "END_ARRAY", "VALUE_SEPARATOR", 
			"NAME_SEPARATOR", "FALSE", "TRUE", "NULL", "STRING", "NUMBER", "INT", 
			"EXP", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'['", "'{'", "'}'", "']'", "','", "':'", "'false'", "'true'", 
			"'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "BEGIN_ARRAY", "BEGIN_OBJECT", "END_OBJECT", "END_ARRAY", "VALUE_SEPARATOR", 
			"NAME_SEPARATOR", "FALSE", "TRUE", "NULL", "STRING", "NUMBER", "WS"
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


	public JSONLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "JSON.g4"; }

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
		"\u0004\u0000\ft\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t>\b\t\n\t\f\tA\t\t\u0001\t\u0001"+
		"\t\u0001\n\u0003\nF\b\n\u0001\n\u0001\n\u0001\n\u0004\nK\b\n\u000b\n\f"+
		"\nL\u0001\n\u0003\nP\b\n\u0001\n\u0003\nS\b\n\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0003\nY\b\n\u0001\n\u0003\n\\\b\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0005\u000ba\b\u000b\n\u000b\f\u000bd\t\u000b\u0003\u000bf\b\u000b"+
		"\u0001\f\u0001\f\u0003\fj\b\f\u0001\f\u0001\f\u0001\r\u0004\ro\b\r\u000b"+
		"\r\f\rp\u0001\r\u0001\r\u0000\u0000\u000e\u0001\u0001\u0003\u0002\u0005"+
		"\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n"+
		"\u0015\u000b\u0017\u0000\u0019\u0000\u001b\f\u0001\u0000\u0006\u0002\u0000"+
		"\"\"\\\\\u0001\u000009\u0001\u000019\u0002\u0000EEee\u0002\u0000++--\u0003"+
		"\u0000\t\n\r\r  ~\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001"+
		"\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001"+
		"\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000"+
		"\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000"+
		"\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000"+
		"\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000"+
		"\u0000\u0001\u001d\u0001\u0000\u0000\u0000\u0003\u001f\u0001\u0000\u0000"+
		"\u0000\u0005!\u0001\u0000\u0000\u0000\u0007#\u0001\u0000\u0000\u0000\t"+
		"%\u0001\u0000\u0000\u0000\u000b\'\u0001\u0000\u0000\u0000\r)\u0001\u0000"+
		"\u0000\u0000\u000f/\u0001\u0000\u0000\u0000\u00114\u0001\u0000\u0000\u0000"+
		"\u00139\u0001\u0000\u0000\u0000\u0015[\u0001\u0000\u0000\u0000\u0017e"+
		"\u0001\u0000\u0000\u0000\u0019g\u0001\u0000\u0000\u0000\u001bn\u0001\u0000"+
		"\u0000\u0000\u001d\u001e\u0005[\u0000\u0000\u001e\u0002\u0001\u0000\u0000"+
		"\u0000\u001f \u0005{\u0000\u0000 \u0004\u0001\u0000\u0000\u0000!\"\u0005"+
		"}\u0000\u0000\"\u0006\u0001\u0000\u0000\u0000#$\u0005]\u0000\u0000$\b"+
		"\u0001\u0000\u0000\u0000%&\u0005,\u0000\u0000&\n\u0001\u0000\u0000\u0000"+
		"\'(\u0005:\u0000\u0000(\f\u0001\u0000\u0000\u0000)*\u0005f\u0000\u0000"+
		"*+\u0005a\u0000\u0000+,\u0005l\u0000\u0000,-\u0005s\u0000\u0000-.\u0005"+
		"e\u0000\u0000.\u000e\u0001\u0000\u0000\u0000/0\u0005t\u0000\u000001\u0005"+
		"r\u0000\u000012\u0005u\u0000\u000023\u0005e\u0000\u00003\u0010\u0001\u0000"+
		"\u0000\u000045\u0005n\u0000\u000056\u0005u\u0000\u000067\u0005l\u0000"+
		"\u000078\u0005l\u0000\u00008\u0012\u0001\u0000\u0000\u00009?\u0005\"\u0000"+
		"\u0000:;\u0005\\\u0000\u0000;>\t\u0000\u0000\u0000<>\b\u0000\u0000\u0000"+
		"=:\u0001\u0000\u0000\u0000=<\u0001\u0000\u0000\u0000>A\u0001\u0000\u0000"+
		"\u0000?=\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000@B\u0001\u0000"+
		"\u0000\u0000A?\u0001\u0000\u0000\u0000BC\u0005\"\u0000\u0000C\u0014\u0001"+
		"\u0000\u0000\u0000DF\u0005-\u0000\u0000ED\u0001\u0000\u0000\u0000EF\u0001"+
		"\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000GH\u0003\u0017\u000b\u0000"+
		"HJ\u0005.\u0000\u0000IK\u0007\u0001\u0000\u0000JI\u0001\u0000\u0000\u0000"+
		"KL\u0001\u0000\u0000\u0000LJ\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000"+
		"\u0000MO\u0001\u0000\u0000\u0000NP\u0003\u0019\f\u0000ON\u0001\u0000\u0000"+
		"\u0000OP\u0001\u0000\u0000\u0000P\\\u0001\u0000\u0000\u0000QS\u0005-\u0000"+
		"\u0000RQ\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000ST\u0001\u0000"+
		"\u0000\u0000TU\u0003\u0017\u000b\u0000UV\u0003\u0019\f\u0000V\\\u0001"+
		"\u0000\u0000\u0000WY\u0005-\u0000\u0000XW\u0001\u0000\u0000\u0000XY\u0001"+
		"\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z\\\u0003\u0017\u000b\u0000"+
		"[E\u0001\u0000\u0000\u0000[R\u0001\u0000\u0000\u0000[X\u0001\u0000\u0000"+
		"\u0000\\\u0016\u0001\u0000\u0000\u0000]f\u00050\u0000\u0000^b\u0007\u0002"+
		"\u0000\u0000_a\u0007\u0001\u0000\u0000`_\u0001\u0000\u0000\u0000ad\u0001"+
		"\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000"+
		"cf\u0001\u0000\u0000\u0000db\u0001\u0000\u0000\u0000e]\u0001\u0000\u0000"+
		"\u0000e^\u0001\u0000\u0000\u0000f\u0018\u0001\u0000\u0000\u0000gi\u0007"+
		"\u0003\u0000\u0000hj\u0007\u0004\u0000\u0000ih\u0001\u0000\u0000\u0000"+
		"ij\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000kl\u0003\u0017\u000b"+
		"\u0000l\u001a\u0001\u0000\u0000\u0000mo\u0007\u0005\u0000\u0000nm\u0001"+
		"\u0000\u0000\u0000op\u0001\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000"+
		"pq\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000rs\u0006\r\u0000\u0000"+
		"s\u001c\u0001\u0000\u0000\u0000\r\u0000=?ELORX[beip\u0001\u0006\u0000"+
		"\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}