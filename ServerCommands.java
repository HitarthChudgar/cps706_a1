public enum ServerCommands {
    GET_DATE("getDate"),
    GET_TIME("getTime"),
    INVALID_COMMAND("invalid-command");

    private final String command;


    ServerCommands(final String command) {
        this.command = command;
    }


    @Override
    public String toString() {
        return command;
    }
}
