import com.amazon.speech.speechlet.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class BirthdaysSpeechlet implements Speechlet{
    private static final Logger log = LoggerFactory.getLogger(BirthdaysSpeechlet.class);

    private HashMap<Calendar, String> birthdays = new HashMap<>();

    public BirthdaysSpeechlet() {
        birthdays.put(new GregorianCalendar(1735, Calendar.JANUARY, 1), "Paul Revere");
        // Repeat 365 more times
    }

    @Override
    public void onSessionStarted(SessionStartedRequest request, Session session) throws SpeechletException {
        log.info("onSessionStarted requestId={}, sessionId={}", request.getRequestId(), session.getSessionId());
    }

    @Override
    public SpeechletResponse onLaunch(LaunchRequest launchRequest, Session session) throws SpeechletException {
        log.info("onSessionStarted requestId={}, sessionId={}", launchRequest.getRequestId(), session.getSessionId());
        return null;
    }

    @Override
    public SpeechletResponse onIntent(IntentRequest intentRequest, Session session) throws SpeechletException {
        return null;
    }

    @Override
    public void onSessionEnded(SessionEndedRequest sessionEndedRequest, Session session) throws SpeechletException {

    }
}
