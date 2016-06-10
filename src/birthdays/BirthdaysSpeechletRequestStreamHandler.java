package birthdays;

import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;

import java.util.HashSet;
import java.util.Set;

public class BirthdaysSpeechletRequestStreamHandler extends SpeechletRequestStreamHandler {

    private static final Set<String> supportedApplicationIds;

    static {
        /*
         * This Id can be found on https://developer.amazon.com/edw/home.html#/ "Edit" the relevant
         * Alexa Skill and put the relevant Application Ids in this Set.
         */
        supportedApplicationIds = new HashSet<String>();
        supportedApplicationIds.add("amzn1.echo-sdk-ams.app.f5ad9710-4e6f-4a2e-8a5f-aceb7033fcf2");
    }

    public BirthdaysSpeechletRequestStreamHandler() {
        super(new BirthdaysSpeechlet(), supportedApplicationIds);
    }

}