package baseball.controller;

import baseball.view.InputView;
import baseball.view.OutputView;

public class ViewController {

    private final InputView inputView;
    private final OutputView outputView;

    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

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

    public String getContinueIntent() {
        printMessageWithNewLine(GAME_END_MESSAGE);
        return inputView.readLine();
    }

}
