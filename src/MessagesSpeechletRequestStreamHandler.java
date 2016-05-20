

import com.amazon.speech.speechlet.Speechlet;
import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class MessagesSpeechletRequestStreamHandler extends SpeechletRequestStreamHandler {
    private static final Set<String> supportedApplicationIds;

    static {
        supportedApplicationIds = new HashSet<String>();
        supportedApplicationIds.add(""); // TODO Fill in the app ID
    }

    public MessagesSpeechletRequestStreamHandler() {
        super(new MessagesSpeechlet(), supportedApplicationIds);
    }
}
