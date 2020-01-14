import modelandcontext.Context;
import modelandcontext.UserNotesRow;
import sql.*;
import java.time.LocalDate;
import java.util.List;

/**
 *  The program parses simple SQL commands into an Abstract Syntax Tree
 */
public class Launcher
{

    public static void main(String[] args)
    {
        Context context = new Context();

        // Parses the command: USE database1;
        SQLStatement useDatabase = new UseDatabase("database1");
        List<String> database = useDatabase.parseAndReturn(context);
        System.out.println("Databe in use - " + database);

        // Parses the command: SELECT id, name, address FROM users WHERE is_customer IS NOT NULL ORDER BY created;
        // The SELECT part is in Context class
        SQLStatement selectRows = new Select
                        (new From.Builder().table("users").where(
                                new Where.Builder().isCustomer(user -> user.getIsCustomer()).build()).build());
        List<String> selectUsers = selectRows.parseAndReturn(context);
        System.out.println("Users selected:" + selectUsers);

        // Parses the command: INSERT INTO user_notes (id, user_id, note, created) VALUES (1, 1, "Note 1", NOW());
        SQLStatement insertValues =
                new InsertInto
                        ("user_notes", new Values
                              (new UserNotesRow(1, 1, "Note 1", LocalDate.now())));
        List<String> userNotes = insertValues.parseAndReturn(context);
        System.out.println("Notes inserted:" + userNotes);

        // Parses the command: DELETE FROM database2.logs WHERE id < 1000;
        SQLStatement deleteLogs = new DeleteLogs
                (new From.Builder().database("database2").table("logs").
                        where(new Where.Builder().logID(entry -> entry < 1000).build()).build());
        List<String> tablesAfterLogDeletion = deleteLogs.parseAndReturn(context);
        System.out.println("Entries with logs not less than 1000 " +
                "in " + context.getDatabase() + ": " + tablesAfterLogDeletion);
    }
}
