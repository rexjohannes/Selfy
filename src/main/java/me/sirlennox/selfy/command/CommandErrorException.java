package me.sirlennox.selfy.command;

public class CommandErrorException extends RuntimeException {

    private final Command command;

    public CommandErrorException(Command cmd, String msg) {
        super(msg);
        this.command = cmd;
    }

    public Command getCommand() {
        return command;
    }
}
