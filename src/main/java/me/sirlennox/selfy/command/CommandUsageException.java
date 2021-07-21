package me.sirlennox.selfy.command;

public class CommandUsageException extends CommandErrorException {
    public CommandUsageException(Command cmd, String usage) {
        super(cmd, usage);
    }
}
