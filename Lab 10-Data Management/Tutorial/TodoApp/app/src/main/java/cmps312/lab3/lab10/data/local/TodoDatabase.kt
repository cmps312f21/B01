package cmps312.lab3.lab10.data.local;

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cmps312.lab3.lab10.data.local.entity.Project
import cmps312.lab3.lab10.data.local.entity.Todo

@Database(entities = [Todo::class, Project::class],
    version = 1, exportSchema = false)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao

    companion object {
        private var database: TodoDatabase? = null

        fun getDatabase(context: Context): TodoDatabase {
            if (database == null) {
                database = Room.databaseBuilder(
                    context.applicationContext,
                    TodoDatabase::class.java,
                    "todos_db"
                ).fallbackToDestructiveMigration().build()
            }
            return database as TodoDatabase
        }
    }
}