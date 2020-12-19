package com.example.tpintegrador.helper;

public class DatabaseInitializer {

    private static final String TAG = DatabaseInitializer.class.getName();

    public static void populateAsync(@NonNull final AppDatabase db) {
        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    public static void populateSync(@NonNull final AppDatabase db) {
        populateWithTestData(db);
    }

    private static Tarea addTarea(final AppDatabase db, Tarea tarea) {
        db.tareaDao().insertAll(tarea);
        return tarea;
    }

    private static void populateWithTestData(AppDatabase db) {
        addTarea(db, new Tarea("Sacar basura", 2));
        addTarea(db, new Tarea("Lavar platos", 22));
        addTarea(db, new Tarea("Alimentar mascoras", 42));
        addTarea(db, new Tarea("Bañar mascotas", 99));
        addTarea(db, new Tarea("Pasear mascotas", 26));
        addTarea(db, new Tarea("Lavar ropa", 1));
        addTarea(db, new Tarea("Colgar ropa", 21));
        addTarea(db, new Tarea("Planchar ropa", 14));
        addTarea(db, new Tarea("Cocinar", 54));
        addTarea(db, new Tarea("Hacer compras", 87));
        addTarea(db, new Tarea("Pagar facturas", 59));
        addTarea(db, new Tarea("Sacudir mantel", 14));
        addTarea(db, new Tarea("Limpiar pisos", 56));
        addTarea(db, new Tarea("Limpiar vidrios", 31));
        addTarea(db, new Tarea("cambiar focos", 45));

        List<Tarea> tareaList=db.tareaDao().getAll();
    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final AppDatabase mDb;

        PopulateDbAsync(AppDatabase db) {
            mDb = db;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithTestData(mDb);
            return null;
        }

}
