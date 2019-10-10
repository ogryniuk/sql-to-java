package sql;

import modelandcontext.Context;
import java.util.List;

public class InsertInto implements SQLStatement
{

    private String table;
    private Values values;

    public InsertInto(String table, Values values)
    {
        this.table = table;
        this.values = values;
    }

    @Override
    public List<String> parseAndReturn(Context ctx)
    {
        ctx.setTable(table);
        return values.parseAndReturn(ctx);
    }
}

