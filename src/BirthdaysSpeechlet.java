import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.*;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class BirthdaysSpeechlet implements Speechlet{
    private static final Logger log = LoggerFactory.getLogger(BirthdaysSpeechlet.class);

    private class Birthday {
        public Calendar date;
        public String name;

        public Birthday (Calendar date, String name){
            this.date = date;
            this.name = name;
        }
    }

    private ArrayList<Birthday> birthdays = new ArrayList<>();

    public BirthdaysSpeechlet() {
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JANUARY, 1), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JANUARY, 2), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JANUARY, 3), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JANUARY, 4), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JANUARY, 5), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JANUARY, 6), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JANUARY, 7), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JANUARY, 8), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JANUARY, 9), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JANUARY, 10), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JANUARY, 11), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JANUARY, 12), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JANUARY, 13), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JANUARY, 14), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JANUARY, 15), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JANUARY, 16), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JANUARY, 17), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JANUARY, 18), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JANUARY, 19), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JANUARY, 20), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JANUARY, 21), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JANUARY, 22), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JANUARY, 23), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JANUARY, 24), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JANUARY, 25), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JANUARY, 26), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JANUARY, 27), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JANUARY, 28), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JANUARY, 29), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JANUARY, 30), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JANUARY, 31), "Paul Revere"));

        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.FEBRUARY, 1), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.FEBRUARY, 2), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.FEBRUARY, 3), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.FEBRUARY, 4), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.FEBRUARY, 5), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.FEBRUARY, 6), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.FEBRUARY, 7), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.FEBRUARY, 8), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.FEBRUARY, 9), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.FEBRUARY, 10), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.FEBRUARY, 11), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.FEBRUARY, 12), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.FEBRUARY, 13), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.FEBRUARY, 14), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.FEBRUARY, 15), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.FEBRUARY, 16), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.FEBRUARY, 17), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.FEBRUARY, 18), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.FEBRUARY, 19), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.FEBRUARY, 20), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.FEBRUARY, 21), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.FEBRUARY, 22), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.FEBRUARY, 23), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.FEBRUARY, 24), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.FEBRUARY, 25), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.FEBRUARY, 26), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.FEBRUARY, 27), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.FEBRUARY, 28), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.FEBRUARY, 29), "Paul Revere"));

        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MARCH, 1), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MARCH, 2), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MARCH, 3), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MARCH, 4), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MARCH, 5), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MARCH, 6), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MARCH, 7), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MARCH, 8), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MARCH, 9), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MARCH, 10), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MARCH, 11), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MARCH, 12), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MARCH, 13), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MARCH, 14), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MARCH, 15), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MARCH, 16), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MARCH, 17), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MARCH, 18), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MARCH, 19), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MARCH, 20), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MARCH, 21), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MARCH, 22), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MARCH, 23), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MARCH, 24), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MARCH, 25), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MARCH, 26), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MARCH, 27), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MARCH, 28), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MARCH, 29), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MARCH, 30), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MARCH, 31), "Paul Revere"));

        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.APRIL, 1), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.APRIL, 2), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.APRIL, 3), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.APRIL, 4), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.APRIL, 5), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.APRIL, 6), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.APRIL, 7), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.APRIL, 8), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.APRIL, 9), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.APRIL, 10), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.APRIL, 11), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.APRIL, 12), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.APRIL, 13), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.APRIL, 14), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.APRIL, 15), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.APRIL, 16), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.APRIL, 17), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.APRIL, 18), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.APRIL, 19), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.APRIL, 20), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.APRIL, 21), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.APRIL, 22), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.APRIL, 23), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.APRIL, 24), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.APRIL, 25), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.APRIL, 26), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.APRIL, 27), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.APRIL, 28), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.APRIL, 29), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.APRIL, 30), "Paul Revere"));

        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MAY, 1), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MAY, 2), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MAY, 3), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MAY, 4), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MAY, 5), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MAY, 6), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MAY, 7), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MAY, 8), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MAY, 9), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MAY, 10), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MAY, 11), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MAY, 12), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MAY, 13), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MAY, 14), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MAY, 15), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MAY, 16), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MAY, 17), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MAY, 18), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MAY, 19), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MAY, 20), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MAY, 21), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MAY, 22), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MAY, 23), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MAY, 24), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MAY, 25), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MAY, 26), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MAY, 27), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MAY, 28), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MAY, 29), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MAY, 30), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.MAY, 31), "Paul Revere"));

        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JUNE, 1), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JUNE, 2), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JUNE, 3), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JUNE, 4), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JUNE, 5), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JUNE, 6), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JUNE, 7), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1977, Calendar.JUNE, 8), "Kanye West"));        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.APRIL, 9), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JUNE, 10), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JUNE, 11), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JUNE, 12), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JUNE, 13), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JUNE, 14), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JUNE, 15), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JUNE, 16), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JUNE, 17), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JUNE, 18), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JUNE, 19), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JUNE, 20), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JUNE, 21), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JUNE, 22), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JUNE, 23), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JUNE, 24), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JUNE, 25), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JUNE, 26), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JUNE, 27), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JUNE, 28), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JUNE, 29), "Paul Revere"));
        birthdays.add(new Birthday(new GregorianCalendar(1735, Calendar.JUNE, 30), "Paul Revere"));
        // Repeat 365 more times
    }

    @Override
    public void onSessionStarted(SessionStartedRequest request, Session session) throws SpeechletException {
        log.info("onSessionStarted requestId={}, sessionId={}", request.getRequestId(), session.getSessionId());
    }

    @Override
    public SpeechletResponse onLaunch(LaunchRequest launchRequest, Session session) throws SpeechletException {
        log.info("onSessionStarted requestId={}, sessionId={}", launchRequest.getRequestId(), session.getSessionId());

        String speechOutput = "Ask me who has a birthday today.";
        // If the user either does not reply to the welcome message or says
        // something that is not understood, they will be prompted again with this text.
        String repromptText = "You can ask, who has a birthday today?";

        // Here we are prompting the user for input
        return newAskResponse(speechOutput, repromptText);
    }

    @Override
    public SpeechletResponse onIntent(IntentRequest request, Session session) throws SpeechletException {
        log.info("onIntent requestId={}, sessionId={}", request.getRequestId(),
                session.getSessionId());

        Intent intent = request.getIntent();
        String intentName = (intent != null) ? intent.getName() : null;

        if ("GetBirthdaysIntent".equals(intentName)) {
            return getBirthdays();

        } else if ("AMAZON.HelpIntent".equals(intentName)) {
            return getHelpResponse();

        } else if ("AMAZON.StopIntent".equals(intentName)) {
            PlainTextOutputSpeech outputSpeech = new PlainTextOutputSpeech();
            outputSpeech.setText("Goodbye");

            return SpeechletResponse.newTellResponse(outputSpeech);
        } else if ("AMAZON.CancelIntent".equals(intentName)) {
            PlainTextOutputSpeech outputSpeech = new PlainTextOutputSpeech();
            outputSpeech.setText("Goodbye");

            return SpeechletResponse.newTellResponse(outputSpeech);
        } else {
            throw new SpeechletException("Invalid Intent");
        }
    }

    @Override
    public void onSessionEnded(SessionEndedRequest request, Session session) throws SpeechletException {
        log.info("onSessionEnded requestId={}, sessionId={}", request.getRequestId(),
                session.getSessionId());
    }

    private SpeechletResponse getBirthdays() {
        Calendar c = new GregorianCalendar();
        c.setTime(new Date());

        int index = birthdays.indexOf(c.DAY_OF_YEAR - 1);
        String speechText = birthdays.get(index).name + " was born today in " + birthdays.get(index).date.YEAR + ".";

        // Create the Simple card content.
        SimpleCard card = new SimpleCard();
        card.setTitle("SpaceGeek");
        card.setContent(speechText);

        // Create the plain text output.
        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);

        return SpeechletResponse.newTellResponse(speech, card);
    }

    private SpeechletResponse newAskResponse(String stringOutput, String repromptText) {
        PlainTextOutputSpeech outputSpeech = new PlainTextOutputSpeech();
        outputSpeech.setText(stringOutput);

        PlainTextOutputSpeech repromptOutputSpeech = new PlainTextOutputSpeech();
        repromptOutputSpeech.setText(repromptText);
        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(repromptOutputSpeech);

        return SpeechletResponse.newAskResponse(outputSpeech, reprompt);
    }

    private SpeechletResponse getHelpResponse() {
        String speechText = "You can ask who has a birthday today, or, you can say exit. " +
                "What can I help you with?";

        // Create the plain text output.
        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);

        // Create reprompt
        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(speech);

        return SpeechletResponse.newAskResponse(speech, reprompt);
    }
}
