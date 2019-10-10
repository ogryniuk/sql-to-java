package modelandcontext;

import java.time.LocalDate;

public class UserNotesRow
{

    private int id;
    private int userId;
    private String note;
    private LocalDate created;

    public UserNotesRow(int id, int userId, String note, LocalDate created)
    {
        this.id = id;
        this.userId = userId;
        this.note = note;
        this.created = created;
    }

    @Override
    public String toString()
    {
        return id + ", " + userId + ", " + note + ", " + created;
    }
}

