package sql;

import modelandcontext.Context;
import java.util.List;

public class UseDatabase implements SQLStatement
{

    private String database;

    public UseDatabase(String database)
    {
        this.database = database;
    }

    @Override
    public List<String> parseAndReturn(Context ctx)
    {
        return ctx.useDatabase(database);
    }
}
