package com.discipline.app

import android.app.Application
import com.discipline.app.data.DisciplineDatabase

class DisciplineApp : Application() {
    val database: DisciplineDatabase by lazy { DisciplineDatabase.getDatabase(this) }
}