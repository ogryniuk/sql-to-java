package sql;

import modelandcontext.Context;
import java.util.List;

/**
Parent interface for SQL commands
 */
public interface SQLStatement
{

    List<String> parseAndReturn(Context ctx);
}
