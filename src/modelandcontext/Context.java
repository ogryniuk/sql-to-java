package modelandcontext;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Creates the inner workings of the databases in which SQL commands would be used
 */
public class Context
{

    // Retrieves three instances of database clusters, one cluster per database
    private static List<Map<String, List<UserRow>>> databasesForUsers = DatabasePopulator.getDatabases();
    private static List<Map<String, List<UserNotesRow>>> databasesForUserNotes = DatabasePopulator.getDatabases();
    private static List<Map<String, List<Integer>>> databasesForLogs = DatabasePopulator.getDatabases();

    // Retrieves the databases themselves
    private Map<String, List<UserRow>> usersDatabase = databasesForUsers.get(0);
    private Map<String, List<UserNotesRow>> userNotesDatabase = databasesForUserNotes.get(0);
    private Map<String, List<Integer>> logsDatabase = databasesForLogs.get(1);

    private String database;
    private String table;

    private Predicate<UserRow> isCustomerFilter;
    private Predicate<Integer> logIdFilter;

    private UserNotesRow userNotesRow;

    public void setDatabase(String database)
    {
        this.database = database;
    }

    public String getDatabase()
    {
        return database;
    }

    public void setTable(String table)
    {
        this.table = table;
    }

    public void setCustomerStatusFilter(Predicate<UserRow> isCustomerFilter)
    {
        this.isCustomerFilter = isCustomerFilter;
    }

    public void setLogIdFilter(Predicate<Integer> logIdFilter)
    {
        this.logIdFilter = logIdFilter;
    }

    public void setValuesForUserNotes(UserNotesRow userNotesRow)
    {
        this.userNotesRow = userNotesRow;
    }

    public List<String> useDatabase(String chosenDatabase)
    {
            setDatabase(chosenDatabase);
            return List.of(chosenDatabase);
    }

    /**
    An equivalent of a complex SQL SELECT. Created with a Stream and Predicate
     */
    public List<String> select()
    {
        List <String> selectResult = usersDatabase.entrySet()
                .stream()

                // Corresponds to FROM clause
                .filter(entry -> entry.getKey().equalsIgnoreCase(table))
                .flatMap(entry -> Stream.of(entry.getValue()))
                .flatMap(Collection::stream)

                // Corresponds to WHERE clause
                .filter(isCustomerFilter)

                // Corresponds to the clause ORDER BY
                .sorted((Comparator.comparing(UserRow::getCreated)))

                // Corresponds to SELECT clause.
                // You can chose other ones by invoking the corresponding methods of Row class
                .flatMap(entry -> Stream.of(
                entry.toStringId(),
                entry.toStringName(),
                entry.toStringAddress()))
                .collect(Collectors.toList());

        return selectResult;
    }

    public List<String> insertInto()
    {
        List<UserNotesRow> insertValues = userNotesDatabase.get(table);
        insertValues.add(userNotesRow);

        return Arrays.asList(insertValues.toString());
    }

    public List<String> deleteLogs()
    {
        List<Integer> deleteResult = logsDatabase.get(table);
        deleteResult.removeIf(logIdFilter);

        List<String> logsKeptAfterDeletion = new LinkedList<>();
        for(Integer element: deleteResult)
            logsKeptAfterDeletion.add(String.valueOf(element));
        return logsKeptAfterDeletion;
    }
}
