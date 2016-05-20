import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.*;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessagesSpeechlet implements Speechlet{
    private static final Logger log = LoggerFactory.getLogger(MessagesSpeechlet.class);

    @Override
    public void onSessionStarted(SessionStartedRequest sessionStartedRequest, Session session) throws SpeechletException {
    }

    @Override
    public SpeechletResponse onLaunch(LaunchRequest launchRequest, Session session) throws SpeechletException {
        return getHelloResponse();
    }

    @Override
    public SpeechletResponse onIntent(IntentRequest intentRequest, Session session) throws SpeechletException {
        Intent intent = intentRequest.getIntent();
        String intentName = (intent != null) ? intent.getName() : null;

        if (intentName.equals("LogInIntent")) {
            return getHelloResponse();
        } else {
            throw new SpeechletException("Invalid Intent");
        }
    }

    @Override
    public void onSessionEnded(SessionEndedRequest sessionEndedRequest, Session session) throws SpeechletException {

    }

    private SpeechletResponse getHelloResponse() {
        String text = "Hi Shawn";

        SimpleCard card = new SimpleCard();
        card.setTitle("This should be the title");
        card.setContent(text);

        PlainTextOutputSpeech output = new PlainTextOutputSpeech();
        output.setText(text);

        return SpeechletResponse.newTellResponse(output, card);
    }
}
