package com.arctouch.codechallenge.di.component

import com.arctouch.codechallenge.di.module.PersistenceModule
import com.arctouch.codechallenge.di.scope.ActivityScope
import com.arctouch.codechallenge.ui.activity.base.PersistenceNeeded
import dagger.Component

@ActivityScope
@Component(modules = [(PersistenceModule::class)])
interface PersistenceComponent {

    fun inject(persistenceNeeded: PersistenceNeeded)

}