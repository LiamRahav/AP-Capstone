

import com.amazon.speech.speechlet.Speechlet;
import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class MessagesSpeechletRequestStreamHandler extends SpeechletRequestStreamHandler {
    private static final Set<String> supportedApplicationIds;

    static {
        supportedApplicationIds = new HashSet<String>();
        supportedApplicationIds.add("amzn1.echo-sdk-ams.app.b1367079-8c90-4278-b7f2-4e7831ad595e");
    }

    public MessagesSpeechletRequestStreamHandler() {
        super(new MessagesSpeechlet(), supportedApplicationIds);
    }
}
