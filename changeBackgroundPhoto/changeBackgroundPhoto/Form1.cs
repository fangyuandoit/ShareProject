using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace changeBackgroundPhoto
{
    public partial class Form1 : Form
    {

        private static   string filePath = "D:\\picTemp.jpg";
     

        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        /// <summary>
        /// 加载网络图片 预览图片
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void button1_Click(object sender, EventArgs e)
        {
             // 图片下载下来 保存到本地
            string url = "https://uploadbeta.com/api/pictures/random/";
             System.Net.WebClient mywebclient = new System.Net.WebClient();
             mywebclient.DownloadFile(url, filePath);
            // this.pictureBox1.Load(filePath);
            // 把图片预览在C#的 pictureBox控件
            FileStream pFileStream = new FileStream(filePath, FileMode.Open, FileAccess.Read);
            pictureBox1.Image = Image.FromStream(pFileStream);
            pFileStream.Close();
            pFileStream.Dispose();




        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {
           
        }

        /// <summary>
        ///  图片设置为背景图片
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void button2_Click(object sender, EventArgs e)
        {
            MessageBox.Show(filePath);
            SystemParametersInfo(20,1,filePath,1);
        }

        [DllImport("user32.dll",EntryPoint= "SystemParametersInfo")]
        public static extern int SystemParametersInfo(
            int uAction,
            int uParam,
            string lpvParam,
            int fuWinIni
            );
    }
}
