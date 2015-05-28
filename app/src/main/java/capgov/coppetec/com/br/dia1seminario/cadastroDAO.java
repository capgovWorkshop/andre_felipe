package capgov.coppetec.com.br.dia1seminario;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by michel on 27/05/15.
 */
public class cadastroDAO {


    /**
     * Created by michel on 27/05/15.
     */
    public class PessoaDAO {

        private SQLiteDatabase db;
        private Context context;

        public PessoaDAO(Context context) {
            DatabaseHelper dbh = new DatabaseHelper();
            this.db = dbh.getDb();
            this.context = context;
        }

        public ArrayList<Cadastro> getListarCadastro() {

            ArrayList<Cadastro> pessoas = new ArrayList<Cadastro>();
            String selectQuery = "select nome, password, email, data, phone, sex from nome_tabela";


            Cursor cursor = db.rawQuery(selectQuery, null);
            cursor.moveToFirst();

            while(!cursor.isAfterLast()) {

                Cadastro cadastro = new Cadastro();
                cadastro.setNome(cursor.getString(0));
                cadastro.setPassword(cursor.getString(1));
                cadastro.setEmail(cursor.getString(2));

                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                Date dateTime = new Date();
                try {
                    dateTime = format.parse(cursor.getString(3));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                cadastro.setData(dateTime);
                cadastro.setPhone(cursor.getString(4));
                cadastro.setSex(cursor.getString(5));

                pessoas.add(cadastro);

                cursor.moveToNext();
            }

            cursor.close();
            return pessoas;
        }

        public boolean atualizarPassword(Cadastro cadastro) {

            try {

                String tabela = "nome_tabela";
                String whereClause = "id = ?";
                String[] whereArgs = new String[]{ cadastro.getEmail() };

                ContentValues values = new ContentValues(1);
                values.put("password", cadastro.getPassword());

                db.update(tabela, values, whereClause, whereArgs);

            } catch (Exception e) {
                return false;
            }

            return true;
        }

        public boolean inserirPessoa(Cadastro cadastro) {

            try {

                String tabela = "nome_tabela";
                ContentValues values = new ContentValues(6);

                values.put("nome", cadastro.getNome());
                values.put("password", cadastro.getPassword());
                values.put("email", cadastro.getEmail());
                values.put("data", cadastro.getData().toString());
                values.put("phone", cadastro.getPassword());
                values.put("sex", cadastro.getSex());

                int id = (int) db.insertOrThrow(tabela, null, values);

            } catch (Exception e) {
                return false;
            }

            return true;
        }
    }
}
