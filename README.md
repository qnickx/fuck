# WastelandWarCore
## 制作框架
- 城镇
  > 城镇范围 (256 * 256), 四个核心平均分布, 中间基底为基岩, 可容纳 30 人 (人数待定)  
  
  - 社交
    - 玩家及其城民算作一方势力, 城主每占领一座城镇可接纳的城民数量 **+30** 
    - 城主之间可结盟, 结盟后双方势力互相视作友军
    - 在流民向城主发出请求且城主同意接纳后流民成为城民, 城主在任意时刻可放逐城民
    - 流民可自立为叛军首领, 可接纳 **30** 名流民为叛军
    - 流民无法占领信标, 城民占领信标视作城主占领信标, 叛军占领信标视作首领占领信标
    - 大部分社交操作在战争期间禁止进行
      > 如: 自立为叛军
  - 资源
    - 和平时期核心每小时可产出 **1** 颗魔质,最多储存 **10** 颗, 破坏信标可获取
    - 战争时期停止产出,战争时期结束后储存的魔质数量翻倍(可超过上限)
    - 和平时期只能由该方势力的城镇城民挖取魔质
    - 战争期间所有的玩家均可挖取魔质
  - 争夺
    - 战争期间关闭领地保护, 非友军在城镇内受到挖掘疲劳效果并禁止浮空搭建(放置方块时下方不能为空气)
    - 在破坏任意信标后解除非友军负面效果, 当且仅当某一方势力同时占领四个核心且战争结束后占领城镇成功
    > 核心即信标, 被破坏后再生并标记为破坏方实力  
      注: 若四个核心不同为一方实例, 则及时到了和平时期也不开启领地保护
  - 传送、图腾
  - 其他
    - 城镇需提供判断是否在城镇内的接口,以实现一些小细节
      > 如: 只有在城镇内植物生长, 玩家可传送至友军城镇等
- 法杖特殊装备
  - 装备特性
  - 伤害计算
  - 锻造强化
- 综合
  - UI, 快捷操作
  - 收费点
  - 天赋  
  
> 在世界地图上分布着 **9** 个城镇( 数量不定 ), 战争时期(每晚 **19:00-20:00** ) 玩家可通过破坏核心占领城镇,和平时期城镇将开启领地保护,玩家在和平时期可建设城镇或提升自身实力，城镇能产出特殊资源

## 项目结构
```
WastelandWarCore
├─ api 开放API
│   ├─ event 事件API
│
├─ command 命令
│   ├─ core 关于指令Core的子命令
│   ├─ town 关于指令Town的子命令
│
├─ listener 监听器
│
├─ manager 管理层
│
├─ module 模块
│   ├─ common 公共模块
│       ├─ chat 聊天模块
│       ├─ mob 怪物模块
│       ├─ specialeffect 特殊属性模块
│       ├─ talent 天赋模块
│       ├─ ui UI模块
│       ├─ user 用户模块
│   ├─ item 物品模块
│       ├─ wand 法杖
│   ├─ town 城镇模块
│
├─ runnable 调度器
│
├─ util 常用工具类
│
```  

## 编译
本项目使用 _Maven_ 管理, 在编译之前确保你有 _JDK8_ 与 _Maven_ 环境
```
  mvn clean install package
```