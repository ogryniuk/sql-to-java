package modelandcontext;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  Creates databases and their tables
 */
public final class DatabasePopulator
{

    private DatabasePopulator() {}

    private static List<Map<String, List<? extends Object>>> databases = new ArrayList<>();
    private static Map<String, List<? extends Object>> database1 = new HashMap<>();
    private static Map<String, List<? extends Object>> database2 = new HashMap<>();

    static
    {
        // Populates the databases and the tables based on the assignment's data
        List<UserRow> tableOfUsers = new ArrayList<>();
        tableOfUsers.add(new UserRow(1, "Steve", "Queen Ann's street",
                true, LocalDate.of(2019, Month.SEPTEMBER, 25)));
        tableOfUsers.add(new UserRow(2, "Rachel", "Liberty street", true,
                LocalDate.of(2019, Month.AUGUST, 24)));
        tableOfUsers.add(new UserRow(3, "John", "Friendship street", false,
                LocalDate.of(2019, Month.JUNE, 23)));
        tableOfUsers.add(new UserRow(4, "Oliver", "Sunny street", true,
                LocalDate.of(2018, Month.JUNE, 23)));
        database1.put("users", tableOfUsers);

        List<UserNotesRow> tableOfNotes = new ArrayList<>();
        database1.put("user_notes", tableOfNotes);

        List<Integer> tableOfLogs = new ArrayList<>();
        tableOfLogs.add(1);
        tableOfLogs.add(11);
        tableOfLogs.add(111);
        tableOfLogs.add(1111);
        tableOfLogs.add(1112);
        tableOfLogs.add(1113);
        tableOfLogs.add(1114);

        database2.put("logs", tableOfLogs);

        databases.add(database1);
        databases.add(database2);
    }

    public static List getDatabases()
    {
        return databases;
    }
}

