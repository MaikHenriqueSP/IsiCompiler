package ast;

public class CommandComentario extends AbstractCommand {
    private String content;

    public CommandComentario(String content) {
        this.content = content;
    }
    @Override
    public String generateCode() {
        String commentContent = content.replaceAll("#", "");
        return "\n\t\t//" + commentContent + "\n";
    }
    @Override
    public String toString() {
        return "CommandComentario [content=" + content + "]";
    }

}
