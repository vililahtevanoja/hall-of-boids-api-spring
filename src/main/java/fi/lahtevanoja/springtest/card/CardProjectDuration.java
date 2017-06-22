package fi.lahtevanoja.springtest.card;

import java.sql.Date;
import org.joda.time.DateTime;

/**
 * Created on 2017-04-25.
 *
 * @author vili
 */
public class CardProjectDuration {

  private long from;
  private long to;

  CardProjectDuration() {
    this.from = 0;
    this.to = 0;
  }

  CardProjectDuration(long from, long to) {
    this.from = from;
    this.to = to;
  }

  CardProjectDuration(Date from, Date to) {
    this(from.getTime(), to.getTime());
  }

  CardProjectDuration(java.util.Date from, java.util.Date to) {
    this(from.getTime(), to.getTime());
  }

  CardProjectDuration(DateTime from, DateTime to) {
    this(from.getMillis(), to.getMillis());
  }

  public long getFrom() {
    return from;
  }

  public void setFrom(long from) {
    this.from = from;
  }

  public long getTo() {
    return to;
  }

  public void setTo(long to) {
    this.to = to;
  }
}
