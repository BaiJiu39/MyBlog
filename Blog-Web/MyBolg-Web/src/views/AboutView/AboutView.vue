<template>
  <n-flex>
    <n-card class="my">
      <div class="my-conten">
        <n-image src="src\assets\icon_mark.svg"></n-image>
      </div>
      <div style="margin-top: 20px">
        <div>
          <n-h1>关于我</n-h1>
          <GB></GB>
          <p>
            至少见一面让我当面道歉好吗？😭<br />
            我也吓了一跳，没想到事情会演变成那个样子…😭
            <br />所以我想好好说明一下😭<br />
            我要是知道就会阻止她们的，但是明明编排表都已经结束了突然间开始演奏😭<br />
            没能阻止大家真是对不起…😭 <br />小祥，你在生气对吧…😭
            我想你生气也是当然的😭<br />
            但是请你相信我。春日影，本来没有在我们的演奏预定曲目里的😭<br />
            真的很对不起😭<br />
            我答应你再也不会随意演奏了😭<br />
            我会让她们保证再也不演奏这首曲子😭<br />
            能不能稍微谈一谈？😭<br />
            我真的把CRYCHIC的一切看得非常重要😭<br />
            所以说，擅自演奏春日影的时候我和小祥你一样难过
            我希望你能明白我的心情😭 <br />拜托了。我哪里都会去的😭<br />
            我也会好好跟你说明我不得不组乐队的理由😭<br />
            我想如果你能见我一面，你就一定能明白的😭
            <br />我是小祥你的同伴😭<br />
            我好想见你😭<br />
          </p>
        </div>
        <div>
          <n-h1>技能&工具</n-h1>
          <GB></GB>
          <n-grid x-gap="12" :cols="15">
            <n-gi style="margin-top: 10px">
              <b style="font-size: 25px">Skill:</b>
            </n-gi>
            <n-gi
              v-for="(Skills, index) in Skill"
              :key="index"
              class="icon-list icon"
            >
              <n-image
                width="30px"
                :src="Skills.src"
                class="icon-list-icon"
              ></n-image>
            </n-gi>
          </n-grid>
          <n-grid x-gap="1" :cols="16">
            <n-gi style="margin-top: 10px" :span="2"
              ><b style="font-size: 25px">Dev Tools:</b></n-gi
            >
            <n-gi
              v-for="(Tool, index) in Tools"
              :key="index"
              class="icon-list icon"
            >
              <n-image
                width="30px"
                :src="Tool.src"
                class="icon-list-icon"
              ></n-image> </n-gi
          ></n-grid>
        </div>
        <div>
          <n-h1>关于本站</n-h1>
          <GB></GB>
          <p>
            这是我的个人博客，前后端纯手写，参考了Auroral的页面，本页面使用Vue3
            + NaiveUi
          </p>
        </div>
        <div>
          <n-h1>免责申明</n-h1>
          <GB></GB>
          <p>
            本博客中的所有内容仅供参考，均为作者个人观点，不代表任何组织或机构的立场。<br />
            本博客中的信息和内容是基于作者的个人经验和观点，可能存在错误或不准确之处。<br />
            本博客中的文章和内容，除非特别声明，均为作者原创。<br />
            本博客可能包含到其他网站的链接。作者对这些网站的内容不承担任何责任。<br />
            未经授权，严禁转载、复制或用于商业用途。如需转载或引用，请联系作者获取许可，并注明出处。<br />
            外部链接的存在并不表示作者认可其内容或立场。<br />
            读者应自行判断和验证博客中的信息，并对因使用本博客内容而造成的任何后果承担责任。<br />
            作者不对因使用本博客信息而引发的任何直接或间接损失承担责任。<br />
            感谢您的理解和支持！<br />
          </p>
        </div>
        <div>
          <n-h1>联系方式</n-h1>
          <GB></GB>
          <n-flex>
            <n-image width="35px" src="src\assets\RiMailLine.svg"></n-image>
            <p>lijialin39@qq.com</p>
          </n-flex>
        </div>
      </div>
    </n-card>
    <MyCard></MyCard>
  </n-flex>
</template>

<script setup>
import MyCard from '@/components/AboutMyCard/AboutMyCard.vue'
import GB from '@/components/GradientBar/GB.vue'
import { ref } from 'vue'

const Skill = ref([
  { src: 'src/assets/Skill/VscodeIconsFileTypeJar.svg' },
  { src: 'src/assets/Skill/VscodeIconsFileTypeVue.svg' },
  { src: 'src/assets/Skill/LogosSpringIcon.svg' },
  { src: 'src/assets/Skill/VscodeIconsFileTypeMysql.svg' },
  { src: 'src/assets/Skill/LogosRedis.svg' },
  { src: 'src/assets/Skill/LogosRabbitmqIcon.svg' }
])
const Tools = ref([
  { src: 'src/assets/Tools/VscodeIconsFileTypeVscode.svg' },
  { src: 'src/assets/Tools/LogosIntellijIdea.svg' },
  { src: 'src/assets/Tools/VscodeIconsFileTypeMaven.svg' },
  { src: 'src/assets/Tools/VscodeIconsFileTypeGit.svg' },
  { src: 'src/assets/Tools/VscodeIconsFileTypeDocker.svg' }
])
</script>

<style scoped>
.my {
  width: var(--width);
  min-height: var(--height);
  border-radius: 10px;
  padding: 40px;
}
.my-conten {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}
.n-h1 {
  margin-bottom: 0px;
}
p {
  font-size: 20px;
}
.icon {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}
.icon-list {
  width: 45px;
  height: 45px;
  background: linear-gradient(to bottom, #ffffff 60%, #bbbbbb57);

  border-radius: 10px;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}
.icon-list-icon {
  transform: scale(1);
  overflow: hidden;
  transition: all 0.2s;
  cursor: pointer;
}
.icon-list-icon:hover {
  transform: scale(1.3);
}
</style>
