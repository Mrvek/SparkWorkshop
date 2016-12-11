package Domain.JSONS;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mitchell on 11/12/2016.
 */
public interface IJsonMaster {
    public void updateFile(List objects);
    public ArrayList readList() throws IOException, ParseException;
}
