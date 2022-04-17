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

    public static void main(String[] args) {

        String userInput = viewController.getUserInput();
        Result result = gameController.play(BaseballNumbers.createBaseballNumbers(userInput));
        viewController.printMessageWithNewLine(BaseballMessageConverter.resultToOutput(result));
    }
}
