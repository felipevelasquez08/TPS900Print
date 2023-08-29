package com.alternova.printtps900

import android.app.Application
import com.alternova.printtps900.print.model.ConfigurationEnum
import com.common.apiutil.util.SDKUtil
import com.common.apiutil.util.SystemUtil

class PrintApplication : Application() {
    private lateinit var internalModel: ConfigurationEnum

    override fun onCreate() {
        super.onCreate()
        SDKUtil.getInstance(this).initSDK()
        if (!SystemUtil.isInstallServiceApk()) {
            println("${this::class.java.simpleName}: API call >> System Reflection")
        } else {
            println("${this::class.java.simpleName}: API call >> Service APK")
        }
        internalModel = ConfigurationEnum.find(SystemUtil.getInternalModel())
        initConfiguration()
    }

    private fun initConfiguration() {
        val testSupports = SystemUtil.getDeviceSupport()
        if (testSupports != null) setConfig(StringArrayToIntArray(testSupports))
        else setConfig(internalModel.values)
    }

    fun StringArrayToIntArray(arr: Array<String>): IntArray {
        val array = IntArray(arr.size)
        for (i in arr.indices) {
            array[i] = arr[i].toInt()
        }
        return array
    }

    companion object {

        private var config: IntArray? = null

        fun setConfig(config: IntArray) = this.apply { this.config = config }

        fun getConfig(): IntArray? = config
    }
}