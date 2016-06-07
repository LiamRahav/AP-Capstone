/**
    Copyright 2014-2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.

    Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with the License. A copy of the License is located at

        http://aws.amazon.com/apache2.0/

    or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 */
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.Card;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import storage.Birthday;
import storage.BirthdaysDynamoDbClient;

/**
 * The {@link BirthdaysManager} receives various events and intents and manages the flow of the
 * game.
 */
public class BirthdaysManager {
    /**
     * Intent slot for player name.
     */
    private static final String NAME = "Name";

    /**
     * Intent slot for player score.
     */
    private static final String BIRTHDAY = "Birthday";

    ArrayList<Birthday> birthdays;


    public BirthdaysManager() {
        birthdays = new ArrayList<>();
    }

    /**
     * Creates and returns response for the add player intent.
     *
     * @param intent
     *            {@link Intent} for this request
     * @param session
     *            Speechlet {@link Session} for this request
     * @param skillContext
     * @return response for the add player intent.
     */
    public SpeechletResponse getAddBirthdayIntentResponse(Intent intent, Session session,
            SkillContext skillContext) {
        // add a player to the current game,
        // terminate or continue the conversation based on whether the intent
        // is from a one shot command or not.
        String newBirthdayUser = null;
        String newBirthdayDate = null;

        if (newBirthdayUser == null) {
            String speechText = "Whose birthday do you want to add?";
            return getAskSpeechletResponse(speechText, speechText);
        }
        if (newBirthdayDate == null) {
            String speechText = "When is their birthday?";
            return getAskSpeechletResponse(speechText, speechText);
        }

        Birthday newBirthday = new Birthday(newBirthdayUser, newBirthdayDate);
        birthdays.add(newBirthday);

        String speechText = "You added a birthday for " + newBirthdayUser + " on " + newBirthdayDate;
        return getTellSpeechletResponse(speechText);
    }

    /**
     * Creates and returns response for the tell scores intent.
     *
     * @param intent
     *            {@link Intent} for this request
     * @param session
     *            {@link Session} for this request
     * @return response for the tell scores intent
     */
    public SpeechletResponse getTellScoresIntentResponse(Intent intent, Session session) {
        // tells the scores in the leaderboard and send the result in card.
        String speechText = getUsers(birthdays);

        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);

        return SpeechletResponse.newTellResponse(speech);
    }

    /**
     * Creates and returns response for the help intent.
     *
     * @param intent
     *            {@link Intent} for this request
     * @param session
     *            {@link Session} for this request
     * @param skillContext
     *            {@link SkillContext} for this request
     * @return response for the help intent
     */
    public SpeechletResponse getHelpIntentResponse(Intent intent, Session session,
            SkillContext skillContext) {
        return getTellSpeechletResponse("help needed");
    }

    /**
     * Creates and returns response for the exit intent.
     *
     * @param intent
     *            {@link Intent} for this request
     * @param session
     *            {@link Session} for this request
     * @param skillContext
     *            {@link SkillContext} for this request
     * @return response for the exit intent
     */
    public SpeechletResponse getExitIntentResponse(Intent intent, Session session,
            SkillContext skillContext) {
        // TODO
    }

    /**
     * Returns an ask Speechlet response for a speech and reprompt text.
     *
     * @param speechText
     *            Text for speech output
     * @param repromptText
     *            Text for reprompt output
     * @return ask Speechlet response for a speech and reprompt text
     */
    private SpeechletResponse getAskSpeechletResponse(String speechText, String repromptText) {
        // Create the Simple card content.
        SimpleCard card = new SimpleCard();
        card.setTitle("Session");
        card.setContent(speechText);

        // Create the plain text output.
        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);

        // Create reprompt
        PlainTextOutputSpeech repromptSpeech = new PlainTextOutputSpeech();
        repromptSpeech.setText(repromptText);
        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(repromptSpeech);

        return SpeechletResponse.newAskResponse(speech, reprompt, card);
    }

    /**
     * Returns a tell Speechlet response for a speech and reprompt text.
     *
     * @param speechText
     *            Text for speech output
     * @return a tell Speechlet response for a speech and reprompt text
     */
    private SpeechletResponse getTellSpeechletResponse(String speechText) {
        // Create the Simple card content.
        SimpleCard card = new SimpleCard();
        card.setTitle("Session");
        card.setContent(speechText);

        // Create the plain text output.
        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);

        return SpeechletResponse.newTellResponse(speech, card);
    }

    /**
     * Converts a {@link Map} of scores into text for speech. The order of the entries in the text
     * is determined by the order of entries in {@link Map#entrySet()}.
     *
     * @param birthdays
     *            A {@link Map} of scores
     * @return a speech ready text containing scores
     */
    private String getUsers(ArrayList<Birthday> birthdays) {
        StringBuilder speechText = new StringBuilder();
        for (Birthday birthday : birthdays) {
            speechText.append(birthday.getUser());
            speechText.append(" has a birthday today.");
        }
        return speechText.toString();
    }
}
