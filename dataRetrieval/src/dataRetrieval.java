import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;
import com.mongodb.Block;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;

public class dataRetrieval {
	private MongoCollection<Document> c;
	private double[] data;

	public dataRetrieval() {
		MongoClientURI connectionString = new MongoClientURI(/**MONGO URI**/);
		MongoClient mongoClient = new MongoClient(connectionString);
		MongoDatabase database = mongoClient.getDatabase("milkData");
		c = database.getCollection("milkBottles");
		data = toArray(getData(), ' ', 4);
	}

	private String getDoc() {
		Document myDoc = c.find().first();
		return myDoc.toJson();

	}

	public String getData() {
		String d = getDoc();
		String s = d.substring(d.indexOf("data") + 9, d.indexOf('\\'));
		return s;
	}

	private double[] toArray(String s, char c, int length) {
		double[] a = new double[length];
		for (int i = 0; i < length - 1; i++) {
			a[i] = Double.parseDouble(s.substring(0, s.indexOf(c)));
			s = s.substring(s.indexOf(c) + 1);
		}
		return a;
	}

	public int getVolume() {
		data = toArray(getData(), ' ', 4);
		if (data[1] < 4.5)
		{
			if(data[2] < 4.5)
			{
//				if(data[3] < 4.5)
//				{
//					return 3;
//				}
				return 2;
			}
			return 1;
		}
		return 0;
	}

	public int getQuality() {
		data = toArray(getData(), ' ', 4);
		// 200 ohm is 0%
		// 2000 ohm is 100%
		// assume linear relationship, 0-100
		if (getVolume() > 0) {
			double v = data[0];
			double r = (400 * v) / (1 - v/5);
			double goodness = r / 18 - 11.11;
			return (int) goodness;
		}
		return 100;
	}

	public int getOhms() {
		if (getVolume() > 0) {
			double v = data[0];
			double r = (2000 * v) / (5 - v);
			return (int) r;
		}
		return 100;
	}
}