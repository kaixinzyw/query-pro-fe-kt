package cn.cloudself

import cn.cloudself.helpers.expectSqlResult
import cn.cloudself.helpers.query.User
import cn.cloudself.helpers.query.UserQueryPro
import cn.cloudself.query.QueryProConfig
import cn.cloudself.query.exception.MissingParameter
import org.junit.Test
import kotlin.test.assertFailsWith

class UpdateTest {
    @Test
    fun test() {
        QueryProConfig.dryRun = true
        QueryProConfig.beautifySql = false

        // 如果没有传入primary key, 且无where条件, 则报错
        assertFailsWith(MissingParameter::class) {
            UserQueryPro.updateSet(User(name = "hb")).run()
        }

        expectSqlResult("UPDATE `user` SET `age` = ? WHERE `user`.`id` = ?", listOf(18, 1))
        val success1: Boolean = UserQueryPro.updateSet(User(age = 18)).where.id.equalsTo(1).run()

        expectSqlResult("UPDATE `user` SET `age` = ? WHERE `user`.`id` = ?", listOf(18, 2))
        val success2: Boolean = UserQueryPro.updateSet(User(id = 2, age = 18)).run()

        expectSqlResult("UPDATE `user` SET `age` = ? WHERE `user`.`id` = ?", listOf(18, 3))
        val success3: Boolean = UserQueryPro.updateSet(User(id = 3, age = 18)).run()

        expectSqlResult("UPDATE `user` SET `name` = ?, `age` = ? WHERE `user`.`id` = ?", listOf("hb", null, 2))
        val success5: Boolean = UserQueryPro.updateSet(User(id = 2, name = "hb"), true).run()

        expectSqlResult("UPDATE `user` SET `age` = ? WHERE `user`.`id` = ?", listOf(18, 1))
        val success6: Boolean = UserQueryPro.updateSet().id(1).age(18).run()

        expectSqlResult("UPDATE `user` SET `age` = ? WHERE `user`.`name` = ?", listOf(18, "herb"))
        val success7: Boolean = UserQueryPro.updateSet().age(18).where.name.equalsTo("herb").run()
    }
}