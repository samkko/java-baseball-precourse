package baseball;

import baseball.controller.GameController;
import baseball.controller.ViewController;
import baseball.converter.BaseballMessageConverter;
import baseball.model.BaseballNumbers;
import baseball.model.Result;
import baseball.view.ConsoleOutputView;
import baseball.view.NextStepInputView;

public class Application {

    private static final ViewController viewController = new ViewController(new NextStepInputView(), new ConsoleOutputView());
    private static final GameController gameController = new GameController();
    private static final String CONTINUE_SIGN = "1";
    private static final String END_SIGN = "2";

    public static void main(String[] args) {

        while(playGame().equals(CONTINUE_SIGN)) {
            gameController.init();
        }
    }

    private static String playGame() {

        Result result = gameController.play(BaseballNumbers.createBaseballNumbers(viewController.getUserInput()));
        viewController.printMessageWithNewLine(BaseballMessageConverter.resultToOutput(result));

        while(!result.isDone()) {
            result = gameController.play(BaseballNumbers.createBaseballNumbers(viewController.getUserInput()));
            viewController.printMessageWithNewLine(BaseballMessageConverter.resultToOutput(result));
        }

        String continueIntent = viewController.getContinueIntent();

        validateContinueIntent(continueIntent);

        return continueIntent;
    }

    private static void validateContinueIntent(String continueIntent) {
        if(continueIntent.equals(CONTINUE_SIGN) || continueIntent.equals(END_SIGN)) {
            return;
        }

        throw new IllegalArgumentException("Invalid Sign.");
    }
}
