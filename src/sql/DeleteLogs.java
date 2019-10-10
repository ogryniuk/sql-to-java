package sql;

import modelandcontext.Context;
import java.util.List;

public class DeleteLogs implements SQLStatement
{

    private From from;

    public DeleteLogs(From from)
    {
        this.from = from;
    }

    @Override
    public List<String> parseAndReturn(Context ctx)
    {
        return from.parseAndReturn(ctx);
    }
}
