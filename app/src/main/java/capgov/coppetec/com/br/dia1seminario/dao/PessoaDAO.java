package capgov.coppetec.com.br.dia1seminario.dao;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageStats;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import capgov.coppetec.com.br.dia1seminario.model.Pessoa;

public class PessoaDAO {

    private SQLiteDatabase db;
    private Context context;

    public PessoaDAO(Context context) {
        DBHelper dbh = new DBHelper(context);
        this.db = dbh.getDb();
        this.context = context;
    }

    public List<Pessoa> getListarCadastro() {

        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        String[] columns = {Pessoa.KEY_NOME, Pessoa.KEY_EMAIL, Pessoa.KEY_SENHA, Pessoa.KEY_DATA, Pessoa.KEY_TELEFONE, Pessoa.KEY_SEXO};
        String selection = "";
        String selectionArgs [] = {};
        String groupBy = "";
        String having = "";
        String orderBy = "";
        String limit = "";

        Cursor cursor =
                db.query(Pessoa.TABLE, // a. table
                        columns, // b. column names
                        selection, // c. selections
                        selectionArgs, // d. selections args
                        groupBy, // e. group by
                        having, // f. having
                        orderBy, // g. order by
                        limit); // h. limit

        cursor.moveToFirst();

        while(!cursor.isAfterLast()) {

            Pessoa pessoa = new Pessoa();
            pessoa.setNome(cursor.getString(0));
            pessoa.setSenha(cursor.getString(1));
            pessoa.setEmail(cursor.getString(2));

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date dateTime = new Date();
            try {
                dateTime = format.parse(cursor.getString(3));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            pessoa.setData(dateTime);
            pessoa.setTelefone(cursor.getString(4));
            pessoa.setSexo(cursor.getString(5));

            pessoas.add(pessoa);

            cursor.moveToNext();
        }

        cursor.close();
        return pessoas;
    }

    public List<Pessoa> getListarCadastro2() {

        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        String selectQuery = "SELECT " +
                Pessoa.KEY_NOME + ", " +
                Pessoa.KEY_EMAIL + ", " +
                Pessoa.KEY_SENHA + ", " +
                Pessoa.KEY_DATA + ", " +
                Pessoa.KEY_TELEFONE + ", " +
                Pessoa.KEY_SEXO  + " FROM ?";

        String params[] = {Pessoa.TABLE};

        Cursor cursor = db.rawQuery(selectQuery, params);
        cursor.moveToFirst();

        while(!cursor.isAfterLast()) {

            Pessoa pess = new Pessoa();
            pess.setNome(cursor.getString(0));
            pess.setSenha(cursor.getString(1));
            pess.setEmail(cursor.getString(2));

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date dateTime = new Date();
            try {
                dateTime = format.parse(cursor.getString(3));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            pess.setData(dateTime);
            pess.setTelefone(cursor.getString(4));
            pess.setSexo(cursor.getString(5));

            pessoas.add(pess);

            cursor.moveToNext();
        }

        cursor.close();
        return pessoas;
    }

    public Pessoa login(String email, String senha) {

        String[] columns = {Pessoa.KEY_NOME, Pessoa.KEY_EMAIL, Pessoa.KEY_SENHA, Pessoa.KEY_DATA, Pessoa.KEY_TELEFONE, Pessoa.KEY_SEXO};
        String selection = Pessoa.KEY_EMAIL + " LIKE  ? AND " + Pessoa.KEY_SENHA + " LIKE ?";
        String selectionArgs [] = {email, senha};
        String groupBy = "";
        String having = "";
        String orderBy = "";
        String limit = "";

        Cursor cursor =
                db.query(Pessoa.TABLE, // a. table
                        columns, // b. column names
                        selection, // c. selections
                        selectionArgs, // d. selections args
                        groupBy, // e. group by
                        having, // f. having
                        orderBy, // g. order by
                        limit); // h. limit

        Pessoa pessoa = null;

        cursor.moveToFirst();

        while(!cursor.isAfterLast()) {

            pessoa = new Pessoa();
            pessoa.setNome(cursor.getString(0));
            pessoa.setSenha(cursor.getString(1));
            pessoa.setEmail(cursor.getString(2));

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date dateTime = new Date();
            try {
                dateTime = format.parse(cursor.getString(3));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            pessoa.setData(dateTime);
            pessoa.setTelefone(cursor.getString(4));
            pessoa.setSexo(cursor.getString(5));
            cursor.moveToNext();
        }

        cursor.close();
        return pessoa;
    }

    public Pessoa login2(String email, String senha) {

        String selectQuery = "SELECT " +
                Pessoa.KEY_NOME + ", " +
                Pessoa.KEY_EMAIL + ", " +
                Pessoa.KEY_SENHA + ", " +
                Pessoa.KEY_DATA + ", " +
                Pessoa.KEY_TELEFONE + ", " +
                Pessoa.KEY_SEXO  + " FROM ? "
                + "Where " + Pessoa.KEY_EMAIL + " LIKE  ? AND " + Pessoa.KEY_SENHA + " LIKE ?";

        String params[] = {email, senha};

        Cursor cursor = db.rawQuery(selectQuery, params);

        Pessoa pessoa = null;

        cursor.moveToFirst();

        while(!cursor.isAfterLast()) {

            pessoa = new Pessoa();
            pessoa.setNome(cursor.getString(0));
            pessoa.setSenha(cursor.getString(1));
            pessoa.setEmail(cursor.getString(2));

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date dateTime = new Date();
            try {
                dateTime = format.parse(cursor.getString(3));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            pessoa.setData(dateTime);
            pessoa.setTelefone(cursor.getString(4));
            pessoa.setSexo(cursor.getString(5));
            cursor.moveToNext();
        }

        cursor.close();
        return pessoa;
    }

    public boolean atualizarDados(Pessoa pessoa) {

        try {

            String tabela = Pessoa.TABLE;
            String whereClause = "email = ?";
            String[] whereArgs = new String[]{ pessoa.getEmail() };

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String data = format.format(pessoa.getData());

            ContentValues values = new ContentValues(6);
            values.put(Pessoa.KEY_NOME, pessoa.getNome());
            values.put(Pessoa.KEY_SENHA, pessoa.getSenha());
            values.put(Pessoa.KEY_EMAIL, pessoa.getEmail());
            values.put(Pessoa.KEY_DATA, data);
            values.put(Pessoa.KEY_TELEFONE, pessoa.getTelefone());
            values.put(Pessoa.KEY_SEXO, pessoa.getSexo());

            db.update(tabela, values, whereClause, whereArgs);

        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public boolean atualizarDados2(Pessoa pessoa) {

        try {

            String[] args = { pessoa.getSenha(), pessoa.getEmail() };
            String query =
                    "UPDATE " + Pessoa.TABLE
                            + " SET "   + Pessoa.KEY_SENHA + "= ?"
                            + " WHERE " + Pessoa.KEY_EMAIL +" Like ?";
            Cursor cursor = db.rawQuery(query, args);
            cursor.moveToFirst();
            cursor.close();

        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public boolean inserirPessoa(Pessoa pessoa) {

        try {

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String data = format.format(pessoa.getData());

            String tabela = Pessoa.TABLE;
            ContentValues values = new ContentValues(6);

            values.put(Pessoa.KEY_NOME, pessoa.getNome());
            values.put(Pessoa.KEY_SENHA, pessoa.getSenha());
            values.put(Pessoa.KEY_EMAIL, pessoa.getEmail());
            values.put(Pessoa.KEY_DATA, data);
            values.put(Pessoa.KEY_TELEFONE, pessoa.getTelefone());
            values.put(Pessoa.KEY_SEXO, pessoa.getSexo());

            int id = (int) db.insertOrThrow(tabela, null, values);

        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public boolean inserirPessoa2(Pessoa pessoa) {

        try {

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String data = format.format(pessoa.getData());

            String[] args = { pessoa.getNome(), pessoa.getEmail(), pessoa.getSenha(), data, pessoa.getTelefone(), pessoa.getSexo()};
            String query =
                    "INSERT ("
                            + Pessoa.KEY_NOME + ", "
                            + Pessoa.KEY_EMAIL + ", "
                            + Pessoa.KEY_SENHA + ", "
                            + Pessoa.KEY_DATA + ", "
                            + Pessoa.KEY_TELEFONE + ", "
                            + Pessoa.KEY_SEXO
                            + ") INTO " + Pessoa.TABLE
                            +" VALUES(?, ?, ?, ?, ?, ?)";
            Cursor cursor = db.rawQuery(query, args);
            cursor.moveToFirst();
            cursor.close();

        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
