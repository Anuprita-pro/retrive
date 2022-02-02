try {
                MongoClient mongoClient = null;
                DBCursor cursor = null;
                mongoClient = new MongoClient( "localhost" , 27017 );
                DB db = mongoClient.getDB( "sofine" );
                DBCollection coll = db.getCollection("info");
                
                
                cursor = coll.find();

                String[] columnNames = {"Name", "Mob", "Add"};
                DefaultTableModel model = new DefaultTableModel(columnNames, 0);

                while(cursor.hasNext()) {
                    DBObject obj = cursor.next();
                    String data1 = (String)obj.get("Name");
                    String data2 = (String)obj.get("Mob");
                    String data3 = (String)obj.get("Add");
                    
                    model.addRow(new Object[] { data1, data2, data3 });
                }
                jTable1.setModel(model);
               }
                    catch(Exception ex)
                        {
                    JOptionPane.showMessageDialog(null,"Exception occured :"+ex);
        }        // T
