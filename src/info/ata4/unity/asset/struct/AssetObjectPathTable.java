/*
 ** 2013 June 17
 **
 ** The author disclaims copyright to this source code.  In place of
 ** a legal notice, here is a blessing:
 **    May you do good and not evil.
 **    May you find forgiveness for yourself and forgive others.
 **    May you share freely, never taking more than you give.
 */
package info.ata4.unity.asset.struct;

import info.ata4.io.DataInputReader;
import info.ata4.io.DataOutputWriter;
import info.ata4.io.Struct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Nico Bergemann <barracuda415 at yahoo.de>
 */
public class AssetObjectPathTable implements Struct, Iterable<AssetObjectPath> {
    
    private List<AssetObjectPath> paths = new ArrayList<>();
    
    public List<AssetObjectPath> getPaths() {
        return paths;
    }
    
    @Override
    public void read(DataInputReader in) throws IOException {
        int entries = in.readInt();

        for (int i = 0; i < entries; i++) {
            AssetObjectPath path = new AssetObjectPath();
            path.read(in);
            paths.add(path);
        }
    }

    @Override
    public void write(DataOutputWriter out) throws IOException {
        int entries = paths.size();
        out.writeInt(entries);

        for (AssetObjectPath path : this) {
            path.write(out);
        }
    }    

    @Override
    public Iterator<AssetObjectPath> iterator() {
        return paths.iterator();
    }
}
