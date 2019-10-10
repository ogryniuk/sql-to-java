package sql;

import modelandcontext.Context;
import java.util.List;

/**
    The class fulfils no specific technical function and is
    created to reproduce SQL syntax
 */
public class Select implements SQLStatement
{

    private From from;

    public Select(From from)
    {
        this.from = from;
    }

    @Override
    public List<String> parseAndReturn(Context ctx)
    {
        return from.parseAndReturn(ctx);
    }
}

