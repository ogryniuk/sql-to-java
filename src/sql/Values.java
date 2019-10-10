package sql;

import modelandcontext.Context;
import modelandcontext.UserNotesRow;
import java.util.List;

public class Values implements SQLStatement
{

    UserNotesRow userNotesRow;

    public Values(UserNotesRow userNotesRow)
    {
        this.userNotesRow = userNotesRow;
    }

    @Override
    public List<String> parseAndReturn(Context ctx)
    {
        ctx.setValuesForUserNotes(userNotesRow);
        return ctx.insertInto();
    }
}

