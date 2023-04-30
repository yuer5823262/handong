from tecplot.constant import ReadDataOption, PlotType
import os
import tecplot as tp
import sys
# tp.session.connect()
tp.new_layout()
rootdir = sys.path[0]+"\\SECRES"
yuntudir = sys.path[0]+"\\yuntu"
dirlist = os.listdir(rootdir) #列出文件夹下所有的目录与文件
for i in range(0,len(dirlist)):
       dirpath = os.path.join(rootdir,dirlist[i])
       flist = os.listdir(dirpath)
       for j in range(0,len(flist)):
              fpath = os.path.join(dirpath,flist[j])
              tp.data.load_tecplot(fpath,read_data_option=ReadDataOption.ReplaceInActiveFrame)
              tp.active_frame().plot().show_contour = True
              tp.active_frame().plot().axes.x_axis.show = False
              tp.active_frame().plot().axes.y_axis.show = False
              tp.active_frame().plot().contour(0).legend.vertical = False
              tp.active_frame().plot().contour(0).legend.position = (95,
              tp.active_frame().plot().contour(0).legend.position[1])

              tp.active_frame().plot().contour(0).legend.position = (
              tp.active_frame().plot().contour(0).legend.position[0],
              95)
              tp.active_frame().plot().contour(0).colormap_name = 'User Defined'
              # tp.active_frame().plot().contour(0).levels.add([0])
              tp.active_frame().plot().contour(0).legend.number_font.size = 2.1
              tp.active_frame().plot().contour(0).variable_index = 2
              tp.export.save_png(yuntudir+"\\"+str(int(dirlist[i]))+"-"+str(int(flist[j][0:4]))+"-"+"1"+'.png', 2000, supersample=3)
              tp.active_frame().plot().contour(0).variable_index = 3
              tp.export.save_png(yuntudir + "\\" + str(int(dirlist[i])) + "-" + str(int(flist[j][0:4])) +"-"+"2"+ '.png', 2000,
                                 supersample=3)
# tecplot.active_frame().plot().show_contour=True
# tecplot.export.save_png('hello_world.png', 1000, supersample=3)