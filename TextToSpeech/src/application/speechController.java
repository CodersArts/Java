package application;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class speechController {
	@FXML
	private Button btn;

	@FXML
	private TextArea text;

	public void speechText() {
		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
		Voice voice;

		VoiceManager vm = VoiceManager.getInstance();
		voice = vm.getVoice("kevin16");
		if (voice != null) {
			voice.allocate();
			try {
				voice.setRate(190);// Setting the rate of the voice
				voice.setPitch(150);// Setting the Pitch of the voice
				voice.setVolume(3);// Setting the volume of the voice
				voice.speak(text.getText());
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			throw new IllegalStateException("Cannot find voice: kevin16");
		}
	}

}