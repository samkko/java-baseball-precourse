package baseball.controller;

import baseball.model.Result;
import baseball.view.InputView;
import baseball.view.OutputView;

public class ViewController {

    private final InputView inputView;
    private final OutputView outputView;

    public ViewController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public String getUserInput() {
        outputView.printMessage("숫자를 입력해주세요 : ");
        return inputView.readLine();
    }

    public void printMessageWithNewLine(String message) {
        outputView.printMessageWithNewLine(message);
    }

}
